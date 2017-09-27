package com.speedyapps.shaftx;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link finnalPageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link finnalPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class finnalPageFragment extends Fragment {
    public static Bundle myBundle;
    public static TextView BendingMoment,combinedShockBending,combinedShockTorsion,Answer1,Answer2;
    public static int temp1,temp2,temp3,temp6,temp7,temp8,temp9,temp10,temp11;
    public static double temp4,temp5,temp12,temp13,temp14,temp15,temp16,temp17,temp18,temp19,temp20,temp21,temp22,temp23,temp24,temp25,temp26,temp27,temp28,temp29,temp30,temp31,temp32,temp33,temp34,temp35,temp36,temp37;
    public static int distanceBearings=0,distanceBearingNGear=0,distanceGearNPulley=0,distancePulleyNBearing=0,diameterOfPulley=0,diameterOfGear=0,weightOfPulley=0,permissibleStress=0,pressureAngleOfGear=0,tensionRatio=0,maxTensionInBelt=0,kForHollowShaft=0;
    public static Button calculate;
    public static Spinner spinner1,spinner2;
    ArrayList list1,list2;
    ArrayAdapter<String> listAdapter1,listAdapter2;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public finnalPageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment finnalPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static finnalPageFragment newInstance(String param1, String param2) {
        finnalPageFragment fragment = new finnalPageFragment();
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
        myBundle=getArguments();
        distanceBearings= Integer.parseInt(myBundle.getString("distanceBearings","0"));
        distanceBearingNGear= Integer.parseInt(myBundle.getString("distanceBearingNGear","0"));
        distanceGearNPulley= Integer.parseInt(myBundle.getString("distanceGearNPulley","0"));
        distancePulleyNBearing= Integer.parseInt(myBundle.getString("distancePulleyNBearing","0"));
        diameterOfPulley= Integer.parseInt(myBundle.getString("diameterOfPulley","0"));
        diameterOfGear= Integer.parseInt(myBundle.getString("diameterOfGear","0"));
        weightOfPulley= Integer.parseInt(myBundle.getString("weightOfPulley","0"));
        permissibleStress= Integer.parseInt(myBundle.getString("permissibleStress","0"));
        pressureAngleOfGear= Integer.parseInt(myBundle.getString("pressureAngleOfGear","0"));
        tensionRatio= Integer.parseInt(myBundle.getString("tensionRatio","0"));
        maxTensionInBelt= Integer.parseInt(myBundle.getString("maxTensionInBelt","0"));
        kForHollowShaft= Integer.parseInt(myBundle.getString("kForHollowShaft","0"));
        temp1=maxTensionInBelt/tensionRatio;

        temp1=maxTensionInBelt/(tensionRatio);
        temp2=(maxTensionInBelt-temp1)*(diameterOfPulley/2);
        try
        {
            temp3=temp2/(diameterOfGear/2);
        }catch (Exception e){
            Toast.makeText(getActivity(), "Devide By Zero Error!! Please CHeck Values Again!", Toast.LENGTH_SHORT).show();
        }
        temp4=pressureAngleOfGear*3.142/180.0;
        temp5=(temp3)*Math.tan(temp4);
        temp6=weightOfPulley;
        temp7=maxTensionInBelt+temp1;
        temp8=((temp3*distanceBearingNGear)+temp6*(distanceBearingNGear+distanceGearNPulley))/distanceBearings;
        temp9=temp3+temp6-temp8;
        temp10=temp9*distanceBearingNGear;
        temp11=temp8*distancePulleyNBearing;
        temp12=((temp5*distanceBearingNGear)+temp7*(distanceBearingNGear+distanceGearNPulley))/distanceBearings;
        temp13=temp5+temp7-temp12;
        temp14=temp13*distanceBearingNGear;
        temp15=temp12*distancePulleyNBearing;
        temp16=Math.pow(temp10,2);
        temp17=Math.pow(temp14,2);
        temp18=Math.pow(temp11,2);
        temp19=Math.pow(temp15,2);
        temp20=Math.sqrt(temp16+temp17);
        temp21=Math.sqrt(temp18+temp19);
        if (temp21>temp20)
        {
            temp22=temp21;
        }
        else
        {
            temp22=temp20;
        }




    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_finnal_page, container, false);
        spinner1=(Spinner)view.findViewById(R.id.statusspinner);
        spinner2=(Spinner)view.findViewById(R.id.loadspinner);
        calculate=(Button)view.findViewById(R.id.calculate);
        BendingMoment=(TextView)view.findViewById(R.id.shaftbendingmoment);
        combinedShockBending=(TextView)view.findViewById(R.id.combinedshockbending);
        combinedShockTorsion=(TextView)view.findViewById(R.id.shockfactorfortorsion);
        Answer1=(TextView)view.findViewById(R.id.answer1);
        Answer2=(TextView)view.findViewById(R.id.answer2);
        list1=new ArrayList();
        list2=new ArrayList();
        list1.add("Rotating");
        list1.add("Stationary");
        list2.add("Steady");
        list2.add("Minor");
        list2.add("Heavy");
        listAdapter1 = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item,list1);
        listAdapter2 = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item,list2);
        spinner1.setAdapter(listAdapter1);
        spinner2.setAdapter(listAdapter2);
        Button Next = (Button) getActivity().findViewById(R.id.next);
        Next.setVisibility(View.INVISIBLE);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                Double twoDigitsF = Double.valueOf(decimalFormat.format(temp22));
                BendingMoment.setText(Double.toString(twoDigitsF));
                switch(spinner1.getSelectedItem().toString()){
                    case "Rotating" :
                        switch(spinner2.getSelectedItem().toString()){
                            case "Steady" :
                                temp23=1.5;
                                temp24=1.0;
                                break;
                            case "Minor" :
                                temp23=2.0;
                                temp24=1.5;
                                break;
                            case "Heavy" :
                                temp23=3.0;
                                temp23=3.0;
                                break;

                        }
                        break;
                    case "Stationary" :
                        switch(spinner2.getSelectedItem().toString()){
                            case "Steady" :
                                temp23=1.0;
                                temp24=1.0;
                                break;
                            case "Minor" :
                                temp23=2.0;
                                temp24=2.0;
                                break;
                            case "Heavy" :
                                temp23=2.0;
                                temp24=2.0;
                                break;

                        }
                        break;
                }
            }
        });
        combinedShockBending.setText(Double.toString(temp23));
        combinedShockTorsion.setText(Double.toString(temp24));
        try {
            temp25 = temp22 * temp23;
            temp26 = temp2 * temp24;
            temp27 = Math.pow(temp25, 2);
            temp28 = Math.pow(temp26, 2);
            temp29 = Math.sqrt(temp27 + permissibleStress);
            temp30 = Math.pow(kForHollowShaft, 4);
            temp31 = 1 / (1 - temp30);
            temp32 = ((temp29 * 16) / (3.142 * permissibleStress * temp31));
            temp33 = Math.pow(temp32, 0.3333);
            Answer1.setText(Double.toString(temp33));
            temp34 = 0.5 * ((temp25) + temp29);
            temp35 = (temp34 * 32 * temp31) / (3.142 * permissibleStress);
            temp36 = Math.pow(temp35,0.3333);
            Answer2.setText(Double.toString(temp36));
        }catch(Exception e){
            Toast.makeText(getActivity(), "Devide By Zero Error ! Check Values Again!", Toast.LENGTH_SHORT).show();
        }
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
}
