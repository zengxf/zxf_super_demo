package cn.zxf.disruptor.demo3;

import lombok.Data;

@Data
public class LongEvent {
    private long value;

    public void set( long value ) {
        this.value = value;
    }
}
