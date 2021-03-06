// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.huizetime.shoppingkotlin.di.component;

import com.huizetime.shoppingkotlin.LoginActivity;
import com.huizetime.shoppingkotlin.LoginActivity_MembersInjector;
import com.huizetime.shoppingkotlin.di.module.LoginActivityModule;
import com.huizetime.shoppingkotlin.di.module.LoginActivityModule_ProvidePresenterFactory;
import com.huizetime.shoppingkotlin.di.module.LoginActivityModule_ProvideViewFactory;
import com.huizetime.shoppingkotlin.presenter.LoginPresenter;
import com.huizetime.shoppingkotlin.view.ILoginView;
import dagger.MembersInjector;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerILoginActivityComponent implements ILoginActivityComponent {
  private Provider<ILoginView> provideViewProvider;

  private Provider<LoginPresenter> providePresenterProvider;

  private MembersInjector<LoginActivity> loginActivityMembersInjector;

  private DaggerILoginActivityComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideViewProvider =
        LoginActivityModule_ProvideViewFactory.create(builder.loginActivityModule);

    this.providePresenterProvider =
        LoginActivityModule_ProvidePresenterFactory.create(
            builder.loginActivityModule, provideViewProvider);

    this.loginActivityMembersInjector =
        LoginActivity_MembersInjector.create(providePresenterProvider);
  }

  @Override
  public void inject(LoginActivity arg0) {
    loginActivityMembersInjector.injectMembers(arg0);
  }

  public static final class Builder {
    private LoginActivityModule loginActivityModule;

    private Builder() {}

    public ILoginActivityComponent build() {
      if (loginActivityModule == null) {
        throw new IllegalStateException(
            LoginActivityModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerILoginActivityComponent(this);
    }

    public Builder loginActivityModule(LoginActivityModule loginActivityModule) {
      this.loginActivityModule = Preconditions.checkNotNull(loginActivityModule);
      return this;
    }
  }
}
