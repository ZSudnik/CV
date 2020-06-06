package com.example.cv.db;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import com.example.cv.db.entity.ExperienceEnt;
import com.example.cv.db.entity.UserEnt;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ExecutionException;


@SuppressLint("StaticFieldLeak")
public class DBRepository {


    private static RoomDB reposDB;
    private static WeakReference<Context> weakReference;

    public DBRepository(Context context) {
        if (reposDB == null) {
            synchronized (DBRepository.class) {
                weakReference = new WeakReference<>( context );
                if (reposDB == null) {
                    reposDB = RoomDB.getAppDatabase( getContext() );
                }

            }
        }
    }

    private static Context getContext() {
        if (weakReference == null || weakReference.get() == null)
            return null;
        return weakReference.get();
    }

    //////////////////////////////////////////////////////////////////
    ////////////// USER CV  ////////////////////////////////////////

    public static void insertCV(final UserEnt oneCV) {
        AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                reposDB.userDAO().insertOne( oneCV );
                return null;
            }

        };
        asyncTask.execute();
    }

    public static List<UserEnt> getAllCV() {
        AsyncTask<Void, Void, List<UserEnt>> asyncTask = new AsyncTask<Void, Void, List<UserEnt>>() {
            @Override
            protected List<UserEnt> doInBackground(Void... voids) {
                return reposDB.userDAO().getAll();
            }

            @Override
            protected void onPostExecute(List<UserEnt> result) {
                // Call context method with results
            }
        };
        asyncTask.execute();
        try {
            return asyncTask.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }


    //////////////////////////////////////////////////////////////////
    ////////////// Experience ///////////////////////////////////////////

    public static void insertExperince(final List<ExperienceEnt> listExperience) {
        AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                reposDB.experienceDAO().insertList( listExperience );
                return null;
            }

        };
        asyncTask.execute();
    }

    public static List<ExperienceEnt> getListExperience(final int idCV) {
        AsyncTask<Void, Void, List<ExperienceEnt>> asyncTask = new AsyncTask<Void, Void, List<ExperienceEnt>>() {
            @Override
            protected List<ExperienceEnt> doInBackground(Void... voids) {
                List<ExperienceEnt> experienceEntList = reposDB.experienceDAO().getAll( idCV);
                return experienceEntList;
            }

            @Override
            protected void onPostExecute(List<ExperienceEnt> result) {
                // Call context method with results
            }
        };
        asyncTask.execute();
        try {
            return asyncTask.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

}