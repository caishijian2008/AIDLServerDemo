package com.csj.aidlserverdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.csj.aidl.IPerson;

/**
 * Created by caishijian on 16-7-11.
 */
public class AIDLService extends Service {

    private IBinder binder = new PersonQueryBinder();

    private String[] names = {"B神","艹神","基神","J神","翔神"};

    private String query(int num) {
        if (num > 0 && num < 6) {
            return names[num - 1];
        }
        return null;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public final class PersonQueryBinder extends IPerson.Stub {
        @Override
        public String queryPerson(int num) throws RemoteException {
            return query(num);
        }
    }

}
