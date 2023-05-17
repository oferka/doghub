package org.hk.doghub.ui.views.site.login;

import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class LoginWithEmail extends VerticalLayout {

    public static final String CLASS_NAME = LoginBody.CLASS_NAME + "-login-with-email";

    private final LoginForm loginForm;

    public LoginWithEmail() {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);
        setPadding(false);

        LoginI18n loginI18n = LoginI18n.createDefault();
        LoginI18n.Form i18nForm = loginI18n.getForm();
        i18nForm.setTitle(EMPTY);
//        i18nForm.setUsername("Käyttäjänimi");
//        i18nForm.setPassword("Salasana");
        i18nForm.setSubmit("Continue");
//        i18nForm.setForgotPassword("Unohtuiko salasana?");
        loginI18n.setForm(i18nForm);
        loginForm = new LoginForm(loginI18n);
        loginForm.setForgotPasswordButtonVisible(false);
        add(loginForm);
    }

    public void setError(BeforeEnterEvent event) {
        loginForm.setError(event.getLocation().getQueryParameters().getParameters().containsKey("error"));
    }

    public void setAction(String action) {
        loginForm.setAction(action);
    }
}
