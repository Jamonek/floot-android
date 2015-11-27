package com.brentlrayjr.floot;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.brentlrayjr.floot.Interfaces.SessionListener;
import com.brentlrayjr.floot.ModelControllers.UserController;
import com.brentlrayjr.floot.Models.User;

public class LoginView extends AppCompatActivity implements View.OnClickListener, SessionListener {

    Toolbar toolbar;
    FloatingActionButton fab;
    Button registerButton;
    EditText emailEditText;
    AutoCompleteTextView usernameTextView;
    EditText passwordEditText;
    CheckBox randomizeUsernameCheckbox;
    CheckBox useCollegeUsernameCheckbox;
    LinearLayout registerCheckboxesLayout;

    UserController userController;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        emailEditText = (EditText) findViewById(R.id.email);
        usernameTextView = (AutoCompleteTextView) findViewById(R.id.username);
        passwordEditText = (EditText) findViewById(R.id.password);

        randomizeUsernameCheckbox = (CheckBox) findViewById(R.id.randomize_username_checkbox);
        useCollegeUsernameCheckbox = (CheckBox) findViewById(R.id.use_college_username_checkbox);

        registerButton = (Button) findViewById(R.id.register_button_view);
        registerCheckboxesLayout = (LinearLayout) findViewById(R.id.register_checkboxes_layout);

        userController = new UserController(this);

        setSupportActionBar(toolbar);
        fab.setOnClickListener(this);
        registerButton.setOnClickListener(this);
        randomizeUsernameCheckbox.setOnClickListener(this);
        useCollegeUsernameCheckbox.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.fab:
                break;
            case R.id.register_button_view:


                userController.login(userController.createUser(emailEditText.getText().toString(), usernameTextView.getText().toString(), passwordEditText.getText().toString()));

                break;
            case R.id.use_college_username_checkbox:
                if (randomizeUsernameCheckbox.isChecked()) {
                    randomizeUsernameCheckbox.toggle();
                }
                break;
            case R.id.randomize_username_checkbox:
                if (useCollegeUsernameCheckbox.isChecked()) {
                    useCollegeUsernameCheckbox.toggle();
                }

                break;
            default:
                break;


        }

    }

    @Override
    public void onLoginAttempt() {

    }

    @Override
    public void onLogoutAttempt() {

    }

    @Override
    public void onLoginSuccess(String session) {

        
    }

    @Override
    public void onLoginFail(String message, String action) {

    }

    @Override
    public void onLogOutSuccess() {

    }

    @Override
    public void onDeregisterAttempt(User user) {

    }

    @Override
    public void onDeregisterFail(String message) {

    }
}
