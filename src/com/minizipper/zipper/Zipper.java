package com.minizipper.zipper;

public class Zipper extends Thread {

    private long totalSize = 0;
    private long procesedSize = 0;
    private long speedSize = 0;
    private boolean cancel = false;
    private boolean wait = false;
    private long readed = 0;
    private long time = 0;


    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public long getProcesedSize() {
        return procesedSize;
    }

    public void setProcesedSize(long procesedSize) {
        this.procesedSize = procesedSize;
    }

    public long getSpeedSize() {
        return speedSize;
    }

    public void setSpeedSize(long speedSize) {
        this.speedSize = speedSize;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public boolean isWait() {
        return wait;
    }

    public void setWait(boolean wait) {
        this.wait = wait;
    }

    public long getReaded() {
        return readed;
    }

    public void setReaded(long readed) {
        this.readed = readed;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
