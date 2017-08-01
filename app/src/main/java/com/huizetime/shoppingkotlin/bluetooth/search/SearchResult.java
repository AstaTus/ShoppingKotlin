package com.huizetime.shoppingkotlin.bluetooth.search;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

import com.huizetime.shoppingkotlin.bluetooth.BluetoothType;
import com.huizetime.shoppingkotlin.bluetooth.exception.BlueTooth20NoScanRecordException;

/**
 * Created by Administrator on 2017/7/31.
 */

public class SearchResult implements Parcelable{
    private BluetoothType mType;
    private BluetoothDevice mDevice;
    private byte[] mScanRecord;
    private int mRssi;
    private long mTimestampNanos;

    public SearchResult(BluetoothDevice device, int rssi, byte[] scan_record,
                      long timestampNanos) {
        mDevice = device;
        mScanRecord = scan_record;
        mRssi = rssi;
        mTimestampNanos = timestampNanos;
    }


    protected SearchResult(Parcel in) {
        mDevice = in.readParcelable(BluetoothDevice.class.getClassLoader());
        mScanRecord = in.createByteArray();
        mRssi = in.readInt();
        mTimestampNanos = in.readLong();
        mType = (BluetoothType)in.readSerializable();
    }



    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mDevice, flags);
        dest.writeByteArray(mScanRecord);
        dest.writeInt(mRssi);
        dest.writeLong(mTimestampNanos);
        dest.writeSerializable(mType);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<SearchResult> CREATOR = new Parcelable.Creator<SearchResult>() {
        @Override
        public SearchResult createFromParcel(Parcel in) {
            return new SearchResult(in);
        }

        @Override
        public SearchResult[] newArray(int size) {
            return new SearchResult[size];
        }
    };

    public BluetoothDevice getDevice() {
        return mDevice;
    }

    public void setDevice(BluetoothDevice device) {
        this.mDevice = device;
    }

    public byte[] getScanRecord() throws BlueTooth20NoScanRecordException {
        if (mType == BluetoothType.BLUETOOTH_2_0)
            throw new BlueTooth20NoScanRecordException();

        return mScanRecord;
    }

    public void setScanRecord(byte[] scanRecord) {
        this.mScanRecord = scanRecord;
    }

    public int getRssi() {
        return mRssi;
    }

    public void setRssi(int rssi) {
        this.mRssi = rssi;
    }

    public long getTimestampNanos() {
        return mTimestampNanos;
    }

    public void setTimestampNanos(long timestampNanos) {
        this.mTimestampNanos = timestampNanos;
    }

    public BluetoothType getBlueType(){return mType;}

    public void setBlueType(BluetoothType type){mType = type;}
}
