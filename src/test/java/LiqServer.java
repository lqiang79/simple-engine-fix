import lombok.extern.slf4j.Slf4j;
import quickfix.*;

import java.io.FileInputStream;

/**
 * Created by qiangli on 21/06/16.
 */
@Slf4j
public class LiqServer implements Application {

    public static void main(String args[]) throws Exception {
        //if (args.length != 1) return;
        String fileName = "/Users/qiangli/Workspace/simple-engine-fix/src/test/java/liq-session-settings.cfg";

        // FooApplication is your class that implements the Application interface
        Application application = new LiqServer();

        SessionSettings settings = new SessionSettings(new FileInputStream(fileName));
        MessageStoreFactory storeFactory = new FileStoreFactory(settings);
        LogFactory logFactory = new FileLogFactory(settings);
        MessageFactory messageFactory = new DefaultMessageFactory();
        Acceptor acceptor = new SocketAcceptor
                (application, storeFactory, settings, logFactory, messageFactory);
        acceptor.start();
        do {

        } while (true);
        //acceptor.stop();
    }

    @Override
    public void onCreate(SessionID sessionID) {
        log.info("onCreate(SessionID={})", sessionID);
    }

    @Override
    public void onLogon(SessionID sessionID) {
        log.info("onLogon(SessionID={})", sessionID);
    }

    @Override
    public void onLogout(SessionID sessionID) {
        log.info("onLogout(SessionID={})", sessionID);
    }

    @Override
    public void toAdmin(Message message, SessionID sessionID) {
        log.info("toAdmin(Message {}, SessionID {})", sessionID);
    }

    @Override
    public void fromAdmin(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        log.info("fromAdmin(Message {}, SessionID {})",message, sessionID);
    }

    @Override
    public void toApp(Message message, SessionID sessionID) throws DoNotSend {
        log.info("toApp(Message {}, SessionID {})", message,sessionID);
    }

    @Override
    public void fromApp(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        log.info("fromApp(Message {}, SessionID {})",message, sessionID);
    }
}
