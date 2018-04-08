package com.fusionjack.adhell3.dialogfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.fusionjack.adhell3.R;

public class FirewallDialogFragment extends DialogFragment {
    private TextView logTextView;
    private Button closeButton;
    private String text = "";

    public static FirewallDialogFragment newInstance(String title) {
        FirewallDialogFragment fragment = new FirewallDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_fragment_firewall, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        logTextView = view.findViewById(R.id.logTextView);
        closeButton = view.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(v -> {
            dismiss();
        });
        closeButton.setEnabled(false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            appendText(bundle.getString("title"));
        }
    }

    public void appendText(String text) {
        this.text += text + "\n";
        logTextView.setText(this.text);
    }

    public void enableCloseButton() {
        closeButton.setEnabled(true);
    }
}