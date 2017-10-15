package my.prog.ipv4v6converter;

import android.app.Application;

import my.prog.ipv4v6converter.di.AppComponent;
import my.prog.ipv4v6converter.di.AppModule;
import my.prog.ipv4v6converter.di.DaggerAppComponent;
import my.prog.ipv4v6converter.di.DataModule;
import my.prog.ipv4v6converter.di.EntityModule;
import my.prog.ipv4v6converter.di.PresenterModule;
import my.prog.ipv4v6converter.di.ViewModule;

/**
 * Created by Ruslan on 12.09.2017.
 */

public class App extends Application {
    private static AppComponent component;
    public static AppComponent getComponent(){
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        buildComponent();
    }

    protected void buildComponent(){
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .dataModule(new DataModule())
                .entityModule(new EntityModule())
                .presenterModule(new PresenterModule())
                .viewModule(new ViewModule())
                .build();
    }

}
