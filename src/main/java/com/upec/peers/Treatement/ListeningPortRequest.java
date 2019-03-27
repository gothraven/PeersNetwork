package com.upec.peers.Treatement;

import com.upec.peers.Server.SerializerBuffer;

import java.nio.ByteBuffer;

public class ListeningPortRequest implements Serializable {

    public static byte ID = 0x02;

    private int port;

    public Creator<ListeningPortRequest> creator = serializerBuffer -> {
        int port = serializerBuffer.readInt();
        return new ListeningPortRequest(port);
    };

    public ListeningPortRequest(int port) {
        this.port = port;
    }

    @Override
    public SerializerBuffer serialize() {
        SerializerBuffer searlizerBuffer = new SerializerBuffer(ByteBuffer.allocate(512));
        searlizerBuffer.writeByte(ID);
        searlizerBuffer.writeInt(port);
        return searlizerBuffer;
    }
}