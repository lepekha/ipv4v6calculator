package my.prog.ipv4v6converter.di;

import javax.inject.Singleton;

import dagger.Component;
import my.prog.ipv4v6converter.data.ImplIpOperations;
import my.prog.ipv4v6converter.other.ImplFunc;
import my.prog.ipv4v6converter.other.ImplPreference;
import my.prog.ipv4v6converter.presenter.ImplTransferIP;
import my.prog.ipv4v6converter.presenter.ImplUpdateUI;
import my.prog.ipv4v6converter.view.ImplMainActivity;

/**
 * Created by Ruslan on 12.09.2017.
 */
@Singleton
@Component(modules = {DataModule.class, EntityModule.class, PresenterModule.class, ViewModule.class, AppModule.class})
public interface AppComponent {
        void inject(ImplMainActivity implMainActivity);
        void inject(ImplUpdateUI implUpdateUI);
        void inject(ImplIpOperations implSetIP);
        void inject(ImplTransferIP implTransferIP);
        void inject(ImplPreference implPreference);
        void inject(ImplFunc implFunc);
}
