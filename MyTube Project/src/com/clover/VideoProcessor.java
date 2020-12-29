package com.clover;

public class VideoProcessor {


    private Encode encoder;
    private Database database;
    private sendEmail send;

    //Construct Injection
    public VideoProcessor(
            Encode encoder,
            Database database,
            sendEmail send
    ) {
        this.encoder = encoder;
        this.database = database;
        this.send = send;
    }

    public void process(Video video) {

        encoder.encode(video);
        database.store(video);
        send.sendEmail(video.getUser());

    }
}

