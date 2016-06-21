package de.berenberg.excon.simpleengine.engine;

import quickfix.*;

import java.io.FileInputStream;

/**
 * Created by qiangli on 21/06/16.
 */
public class EngineService implements Application {
    private static String FILENAME = "/Users/qiangli/Workspace/simple-engine-fix/src/main/resources/liq-settings.cfg";
    private Initiator initiator;

    public void init() throws Exception {
        SessionSettings settings = new SessionSettings(new FileInputStream(FILENAME));
        MessageStoreFactory storeFactory = new FileStoreFactory(settings);
        LogFactory logFactory = new FileLogFactory(settings);
        MessageFactory messageFactory = new DefaultMessageFactory();
        initiator = new SocketInitiator(this, storeFactory, settings, logFactory, messageFactory);
        initiator.start();
    }

    public void destory() {
        if(initiator != null) {
            initiator.stop(true);
        }
    }

    @Override
    public void onCreate(SessionID sessionID) {

    }

    @Override
    public void onLogon(SessionID sessionID) {

    }

    @Override
    public void onLogout(SessionID sessionID) {

    }

    @Override
    public void toAdmin(Message message, SessionID sessionID) {

    }

    @Override
    public void fromAdmin(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {

    }

    @Override
    public void toApp(Message message, SessionID sessionID) throws DoNotSend {

    }

    @Override
    public void fromApp(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {

    }
}
