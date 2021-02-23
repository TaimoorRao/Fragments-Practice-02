package com.example.task03;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class FirstFragment extends Fragment {
    /**
     * Fragments to Fragments Communication Using Shared ViewModel
     */
    private SharedViewModel viewModel;

    /**
     * Fragments to Fragments Communication Using Interface
     */
    private EditText editText;
    private Button button;
//    private FragmentAListener listener;
//    public interface FragmentAListener {
//        void onInputFFSent(CharSequence input);
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first, container, false);

        editText = v.findViewById(R.id.txt_edit);
        button = v.findViewById(R.id.btn_enter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Fragments to Fragments Communication Using Shared ViewModel
                 */
                viewModel.setText(editText.getText());

                /**
                 * Fragments to Fragments Communication Using Interface
                 */
//                CharSequence input = editText.getText();
//                listener.onInputFFSent(input);
            }
        });
        return v;
    }

    /**
     * Fragments to Fragments Communication Using Shared ViewModel
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(getActivity()).get(SharedViewModel.class);
        viewModel.getText().observe(getViewLifecycleOwner(), new Observer<CharSequence>() {
            @Override
            public void onChanged(CharSequence charSequence) {
                editText.setText(charSequence);
            }
        });
    }
    /**
     * Fragments to Fragments Communication Using Interface
     */
//    public void updateEditText(CharSequence newText) {
//        editText.setText(newText);
//    }
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof FragmentAListener) {
//            listener = (FragmentAListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement FragmentBListener");
//        }
//    }
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        listener = null;
//    }
}
