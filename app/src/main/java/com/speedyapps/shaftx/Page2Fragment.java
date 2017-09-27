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
 * {@link Page2Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Page2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Page2Fragment extends Fragment {
    public static EditText weightOfPulley,permissibleStress,angleOfGear,tensionRatio,tensionInBelt,kForHollow;
    public static secondFragmentMessage second;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Page2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Page2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Page2Fragment newInstance(String param1, String param2) {
        Page2Fragment fragment = new Page2Fragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page2, container, false);
        weightOfPulley=(EditText)view.findViewById(R.id.pulleyweight);
        permissibleStress=(EditText)view.findViewById(R.id.permissiblestress);
        angleOfGear=(EditText)view.findViewById(R.id.pressureanglegear);
        tensionRatio=(EditText)view.findViewById(R.id.tesionratio);
        tensionInBelt=(EditText)view.findViewById(R.id.maxtension);
        kForHollow=(EditText)view.findViewById(R.id.ratioForKHollow);
        Button NextButton = (Button)getActivity().findViewById(R.id.next);
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(weightOfPulley.getText().toString().equals("")||permissibleStress.getText().toString().equals("")||angleOfGear.getText().toString().equals("")||tensionRatio.getText().toString().equals("")||tensionInBelt.getText().toString().equals("")||kForHollow.getText().toString().equals(""))
                    Toast.makeText(getActivity(), "Please Enter Valid Input", Toast.LENGTH_SHORT).show();
                else
                    second.messageFromSecond(Integer.parseInt(weightOfPulley.getText().toString()),Integer.parseInt(permissibleStress.getText().toString()),Integer.parseInt(angleOfGear.getText().toString()),Integer.parseInt(tensionRatio.getText().toString()),Integer.parseInt(tensionInBelt.getText().toString()),Integer.parseInt(kForHollow.getText().toString()));
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        second=(secondFragmentMessage)context;
        super.onAttach(context);
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
    public interface secondFragmentMessage{
        void messageFromSecond(int var1,int var2,int var3,int var4,int var5,int var6);
    }
}
