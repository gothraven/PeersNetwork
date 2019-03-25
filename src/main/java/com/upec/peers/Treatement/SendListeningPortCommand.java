package com.upec.peers.Treatement;

import com.upec.peers.Server.SerializerBuffer;

import java.io.Serializable;
import java.nio.ByteBuffer;

public class SendListeningPortCommand {

    public static byte ID = 0x02;

    public static ByteBuffer serialize(int port) {
        SerializerBuffer searlizerBuffer = new SerializerBuffer(ByteBuffer.allocate(512));
        searlizerBuffer.writeByte(ID);
        searlizerBuffer.writeInt(port);
        return searlizerBuffer.getByteBuffer();
    }

    public static int deserialize(ByteBuffer bb) {
        SerializerBuffer byteBuffer = new SerializerBuffer(bb);

        return byteBuffer.readInt();
    }

    public static void main(String[] args) {
        var t = serialize(1234);
        t.rewind();
        var id = t.get();
        assert id == ID;
        System.out.println(deserialize(t));
    }
}