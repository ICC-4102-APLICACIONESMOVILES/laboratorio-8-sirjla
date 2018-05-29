package cl.magnet.mobileappsexample;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import cl.magnet.mobileappsexample.db.Form;
import cl.magnet.mobileappsexample.db.FormViewModel;


public class createForm extends Fragment {

    private FormViewModel formViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_form, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        formViewModel = ViewModelProviders.of(this).get(FormViewModel.class);

        Button createButton = view.findViewById(R.id.Create);
        createButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                insertForm(v.getRootView());
            }
        });

    }

    public void insertForm(View view){
        TextView nameView = (TextView) view.findViewById(R.id.form_name);
        String name = nameView.getText().toString();
        String date = Calendar.getInstance().getTime().toString();

        List<Form> forms = new ArrayList<>();
        forms.add(new Form(1 + (int)(Math.random() * ((100000 - 1) + 1)) ,name, date));
        formViewModel.insert(forms);
    }
}