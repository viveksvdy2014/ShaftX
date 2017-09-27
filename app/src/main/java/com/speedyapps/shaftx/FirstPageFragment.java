package com.speedyapps.shaftx;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FirstPageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FirstPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstPageFragment extends Fragment {
    public static messageSender messagesender;
    public static EditText bearingsDistance,bearingNGear,gearNPully,pulleyNBearing,pulleyDiameter,gearDiameter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FirstPageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstPageFragment newInstance(String param1, String param2) {
        FirstPageFragment fragment = new FirstPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onAttach(Context context) {
        messagesender=(messageSender)context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first_page, container, false);
        bearingsDistance=(EditText)view.findViewById(R.id.bearings);
        bearingNGear=(EditText)view.findViewById(R.id.bearngear);
        gearNPully=(EditText)view.findViewById(R.id.gearnpulley);
        pulleyNBearing=(EditText)view.findViewById(R.id.pullynbearing);
        pulleyDiameter=(EditText)view.findViewById(R.id.pullydia);
        gearDiameter=(EditText)view.findViewById(R.id.geardia);
        Button NextButton = (Button)getActivity().findViewById(R.id.next);
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bearingsDistance.getText().toString().equals("")||bearingNGear.getText().toString().equals("")||gearNPully.getText().toString().equals("")||pulleyNBearing.getText().toString().equals("")||pulleyDiameter.getText().toString().equals("")||gearDiameter.getText().toString().equals(""))
                    Toast.makeText(getActivity(), "Please Enter Valid Input!", Toast.LENGTH_SHORT).show();
                else
                    messagesender.firstFragmentReceiver(Integer.parseInt(bearingsDistance.getText().toString()),Integer.parseInt(bearingNGear.getText().toString()),Integer.parseInt(gearNPully.getText().toString()),Integer.parseInt(pulleyNBearing.getText().toString()),Integer.parseInt(pulleyDiameter.getText().toString()),Integer.parseInt(gearDiameter.getText().toString()));
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    public interface messageSender {
        void firstFragmentReceiver(int val1,int val2,int val3,int val4,int val5,int val6);
    }
}

