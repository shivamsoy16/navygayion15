package com.su.periodictable;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalcFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalcFragment extends Fragment implements View.OnClickListener {

    EditText ET;
    static String test;
    TextView tv;
    String outpt2 = "0";

    static Hashtable hm;
    Hashtable[][] reactpro;
    Hashtable[] templist;
    Hashtable brentry = new Hashtable();
    double output;
    double finaloutput;
    int newid = 0, roundopen = 0, boxopen = 0, fullLen = 0, indexLen = 0, hmrpos = 0, hmcpos = 0, digitvalue = 0, tempindex = 0, suffix = 0;
    String temp = "", args = "";
    boolean keyexists = false, yesno = false;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Object ElementCalculation;

    public CalcFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalcFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalcFragment newInstance(String param1, String param2) {
        CalcFragment fragment = new CalcFragment();
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
        View view = inflater.inflate(R.layout.fragment_calc, container, false);
        onViewCreated(view);
        return view;
    }

    public void onViewCreated(View view) {

        View btn = view.findViewById(R.id.mass_enter);
        tv = view.findViewById(R.id.mass_mass);
        ET = view.findViewById(R.id.mass_edit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test = ET.getText().toString();
                ElementCalculation();
                tv.setText(outpt2);
                Toast.makeText(getActivity(), outpt2, Toast.LENGTH_SHORT).show();


            }
        });


        }


    //----Calculator  Function------------------------//

    public void ElementCalculation() {
        setInitialValues();
        initializeDefaultreactPro();
        accept();
    }
    public void dispose() {
        temp = "";
        roundopen = boxopen = tempindex = hmrpos = hmcpos = digitvalue = fullLen = indexLen = newid = suffix = 0;
        brentry.clear();
        keyexists = yesno = false;
        finaloutput = output = 0;
    }
    private static void setInitialValues() {
        hm = new Hashtable();
        hm.put("H",1.0079);
        hm.put("He", 4.0026);
        hm.put("Li", 6.941);
        hm.put("Be", 9.0122);
        hm.put("B", 10.811);
        hm.put("C",12.0107);
        hm.put("N", 14.0067);
        hm.put("O", 15.9994);
        hm.put("F",18.9984);
        hm.put("Ne", 20.1797);
        hm.put("Na", 22.9897);
        hm.put("Mg", 24.305);
        hm.put("Al", 26.9815);
        hm.put("Si",28.0855);
        hm.put("P", 30.9738);
        hm.put("S", 32.065);
        hm.put("Cl", 35.453);
        hm.put("K", 39.0983);
        hm.put("Ar", 39.948);
        hm.put("Ca", 40.078);
        hm.put("Sc", 44.9559);
        hm.put("Ti", 47.867);
        hm.put("V", 50.9415);
        hm.put("Cr", 51.9961);
        hm.put("Mn", 54.938);
        hm.put("Fe", 55.845);
        hm.put("Ni", 58.6934);
        hm.put("Co", 58.9332);
        hm.put("Cu", 63.546);
        hm.put("Zn", 65.39);
        hm.put("Ga", 69.723);
        hm.put("Ge", 72.64);
        hm.put("As", 74.9216);
        hm.put("Se", 78.96);
        hm.put("Br", 79.904);
        hm.put("Kr", 83.8);
        hm.put("Rb", 85.4678);
        hm.put("Sr", 87.62);
        hm.put("Y", 88.9059);
        hm.put("Zr", 91.224);
        hm.put("Nb", 92.9064);
        hm.put("Mo", 95.94);
        hm.put("Tc", 98);
        hm.put("Ru", 101.07);
        hm.put("Rh", 102.905);
        hm.put("Pd", 106.42);
        hm.put("Ag", 107.8682);
        hm.put("Cd", 112.411);
        hm.put("In", 114.818);
        hm.put("Sn", 118.71);
        hm.put("Sb", 121.76);
        hm.put("I", 126.9045);
        hm.put("Te", 127.6);
        hm.put("Xe", 131.293);
        hm.put("Cs", 132.9055);
        hm.put("Ba", 137.327);
        hm.put("La", 138.9055);
        hm.put("Ce", 140.116);
        hm.put("Pr", 140.9077);
        hm.put("Nd", 144.24);
        hm.put("Pm", 145);
        hm.put("Sm", 150.36);
        hm.put("Eu", 151.964);
        hm.put("Gd", 157.25);
        hm.put("Tb", 158.9253);
        hm.put("Dy", 162.5);
        hm.put("Ho", 164.9303);
        hm.put("Er", 167.259);
        hm.put("Tm", 168.9342);
        hm.put("Yb", 173.04);
        hm.put("Lu", 174.967);
        hm.put("Hf", 178.49);
        hm.put("Ta", 180.9479);
        hm.put("W", 183.84);
        hm.put("Re", 186.207);
        hm.put("Os", 190.23);
        hm.put("Ir", 192.217);
        hm.put("Pt", 195.078);
        hm.put("Au", 196.9665);
        hm.put("Hg", 200.59);
        hm.put("Tl", 204.3833);
        hm.put("Pb", 207.2);
        hm.put("Bi", 208.9804);
        hm.put("Po", 209);
        hm.put("At", 210);
        hm.put("Rn", 222);
        hm.put("Fr", 223);
        hm.put("Ra", 226);
        hm.put("Ac", 227);
        hm.put("Pa", 231.0359);
        hm.put("Th", 232.0381);
        hm.put("Np", 237);
        hm.put("U", 238.0289);
        hm.put("Am", 243);
        hm.put("Pu", 244);
        hm.put("Cm", 247);
        hm.put("Bk", 247);
        hm.put("Cf", 251);
        hm.put("Es", 252);
        hm.put("Fm", 257);
        hm.put("Md", 258);
        hm.put("No", 259);
        hm.put("Rf", 261);
        hm.put("Lr", 262);
        hm.put("Db", 262);
        hm.put("Bh", 264);
        hm.put("Sg", 266);
        hm.put("Mt", 268);
        hm.put("Rg", 272);
        hm.put("Hs", 277);
        hm.put("Ds", 280);
    }

    //This function is created temporary to test the functinality in BBD
    private void initializeDefaultreactPro() {
        reactpro = new Hashtable[2][];
        reactpro[0] = new Hashtable[1];
        reactpro[1] = new Hashtable[1];
        initializeReactPro();
    }
    //For initializing the reactPro Hashtable
    private void initializeReactPro() {
        for (int i = 0; i < reactpro.length; i++)

        {
            for (int j = 0; j < reactpro[i].length; j++)
                reactpro[i][j] = new Hashtable();
        }
    }
    private boolean contains(String args) {
        yesno = false;
        for (int i = 0; i < args.length(); i++) {
            if (args.charAt(i) == '(' || args.charAt(i) == '[') {
                yesno = true;
                break;
            }
        }
        return yesno;
    }
    public void accept() {
        try {
            System.out.println("Enter your expression");
            args = test;
            if (contains(args) == true)
                getNoOfBrackets(args);
            reactpro[hmrpos][hmcpos].clear();
            calculateLength(args);
            matchElementToUpdate(reactpro[hmrpos][hmcpos], brentry);
            calculateMolWeight(hmrpos, hmcpos);
        } catch (Exception e1) {}
    }

    //to calculate the no of Brackets appearing in the string
    private void getNoOfBrackets(String args) {
        for (int i = 0; i < args.length(); i++) {
            if (args.charAt(i) == '(' || args.charAt(i) == '[')
                tempindex++;
        }
        templist = new Hashtable[tempindex];

        tempindex = 0;
        initializeTempHash();
    }
    /*intialized the templist hashtable*/
    private void initializeTempHash() {
        for (int i = 0; i < templist.length; i++)
            templist[i] = new Hashtable();
    }
    private void calculateLength(String args) {
        fullLen = args.length();
        indexLen = fullLen - 1;
        readAtom(args);
    }
    //for calculating the next position within the String array.
    private int calculateNextPosition(int org) {
        int id = 0;
        if (org == fullLen - 1) {
            if (boxopen > 0 || roundopen > 0)
                id = org;
            else
                id = 0;
        } else if (org < fullLen - 1)
            id = org + 1;
        newid = id;
        return newid;
    }
    private void readAtom(String args) {
        for (int i = 0, nxtpos = 0; i < args.length(); i++) {
            temp = "";
            nxtpos = calculateNextPosition(i);
            if (Character.isUpperCase(args.charAt(i)) && Character.isUpperCase(args.charAt(indexLen - (indexLen - nxtpos)))) {
                temp = String.valueOf(args.charAt(i));
                addentry(1);
            } else if (Character.isUpperCase(args.charAt(i)) && (args.charAt(indexLen - (indexLen - nxtpos)) == '[' || args.charAt(indexLen - (indexLen - nxtpos)) == '(')) {
                temp = String.valueOf(args.charAt(i));
                addentry(1);

                if (args.charAt(indexLen - (indexLen - nxtpos)) == '(')
                    roundopen++;
                else
                    boxopen++;
                // suffix = 1;
                i = readBrackets(args, indexLen - (indexLen - nxtpos));
            } else if (Character.isUpperCase(args.charAt(i)) && Character.isDigit(args.charAt(indexLen - (indexLen - nxtpos)))) {

                temp = String.valueOf(args.charAt(i));
                //keyexists = reactpro[hmrpos][hmcpos].containsKey(temp);
                i = IsDigit(args, indexLen - (indexLen - nxtpos));
                addentry(digitvalue);
            } else if (Character.isUpperCase(args.charAt(i))) {
                temp = String.valueOf(args.charAt(i));
                i = readLower(args, i);
                i = i - 1;
            } else if (args.charAt(i) == '[') {
                boxopen++;
                if (!brentry.isEmpty()) {
                    addToTempHash();
                    tempindex++;
                }
                i = readBrackets(args, i);
            } else if (args.charAt(i) == '(') {
                roundopen++;
                if (!brentry.isEmpty()) {
                    addToTempHash();
                    tempindex++;
                }
                i = readBrackets(args, i);
            }
        }
    }
    //This function is used for reading the elements having lower case letters and also for reading the digits
    private int readLower(String args, int idx) {
        for (int j = idx + 1, nxtpos = 0; j < args.length(); j++) {
            nxtpos = calculateNextPosition(j);
            if (Character.isLowerCase(args.charAt(j)) && (!(Character.isDigit(args.charAt(indexLen - (indexLen - nxtpos))) || Character.isLowerCase(args.charAt(indexLen - (indexLen -
                    nxtpos)))))) {
                temp += String.valueOf(args.charAt(j));
                if (roundopen == 0 && boxopen == 0)
                    addentry(1);
                else {
                    if (!brentry.isEmpty()) {
                        addToTempHash();
                        tempindex++;
                    }
                    addentry(1);
                }
            } else if (Character.isLowerCase(args.charAt(j)) && Character.isDigit(args.charAt(indexLen - (indexLen - nxtpos)))) {
                temp += String.valueOf(args.charAt(j));
                j = IsDigit(args, indexLen - (indexLen - nxtpos));
                addentry(digitvalue);
            } else if (Character.isLowerCase(args.charAt(j)) && args.charAt(indexLen - (indexLen - nxtpos)) == '[') {
                temp += String.valueOf(args.charAt(j));
                addentry(1);
                boxopen++;
                //suffix=1;
                addToTempHash();
                tempindex++;
                j = readBrackets(args, indexLen - (indexLen - nxtpos));
            } else if (Character.isLowerCase(args.charAt(j)) && args.charAt(indexLen - (indexLen - nxtpos)) == '(') {
                temp += String.valueOf(args.charAt(j));
                addentry(1);
                roundopen++;
                //suffix=1;
                addToTempHash();
                tempindex++;
                j = readBrackets(args, indexLen - (indexLen - nxtpos));
            } else if (Character.isDigit(args.charAt(j)) && args.charAt(indexLen - (indexLen - nxtpos)) == ')') {
                j = IsDigit(args, j);
                if (roundopen > 1) {
                    keyexists = brentry.containsKey(temp);
                    if (keyexists) {
                        suffix = digitvalue;
                        j = IsDigit(args, indexLen - (indexLen - nxtpos) + 1);
                        digitvalue *= suffix;
                        suffix = 0;
                        addentry(digitvalue);
                        roundopen--;
                    } else
                        addentry(digitvalue);
                } else
                    addentry(digitvalue);
            } else if (Character.isDigit(args.charAt(j)) && args.charAt(indexLen - (indexLen - nxtpos)) == ']') {
                j = IsDigit(args, j);
                if (boxopen > 1) {
                    keyexists = brentry.containsKey(temp);
                    if (keyexists) {
                        suffix = digitvalue;
                        j = IsDigit(args, indexLen - (indexLen - nxtpos) + 1);
                        digitvalue *= suffix;
                        suffix = 0;
                        addentry(digitvalue);
                        boxopen--;
                    } else
                        addentry(digitvalue);
                } else
                    addentry(digitvalue);
            } else if (Character.isLowerCase(args.charAt(j))) {
                temp += String.valueOf(args.charAt(j));
                for (int k = j + 1, nxtpos1 = 0; j < args.length(); k++) {
                    nxtpos1 = calculateNextPosition(k);
                    if (Character.isLowerCase(args.charAt(k)) && !Character.isDigit(args.charAt(indexLen - (indexLen - nxtpos1)))) {
                        temp += String.valueOf(args.charAt(k));
                        addentry(1);
                    } else if (Character.isLowerCase(args.charAt(k)) && Character.isDigit(args.charAt(indexLen - (indexLen - nxtpos1)))) {
                        temp += String.valueOf(args.charAt(k));
                        k = IsDigit(args, k);
                        addentry(digitvalue);
                    } else if (Character.isLowerCase(args.charAt(k)) && args.charAt(indexLen - (indexLen - nxtpos1)) == '[') {
                        temp += String.valueOf(args.charAt(k));
                        addentry(1);
                        boxopen++;
                        k = readBrackets(args, indexLen - (indexLen - nxtpos1));
                    } else if (Character.isLowerCase(args.charAt(k)) && args.charAt(indexLen - (indexLen - nxtpos1)) == '(') {
                        temp += String.valueOf(args.charAt(k));
                        addentry(1);
                        roundopen++;
                        k = readBrackets(args, indexLen - (indexLen - nxtpos1));
                    } else if (Character.isDigit(args.charAt(k))) {
                        k = IsDigit(args, k);
                        addentry(digitvalue);
                    } else if (Character.isUpperCase(args.charAt(k))) {
                        j = k - 1;
                        break;
                    } else {
                        j = k - 1;
                        break;
                    }
                }
            } else if (Character.isDigit(args.charAt(j)) && args.charAt(indexLen - (indexLen - nxtpos)) != ')') {
                j = IsDigit(args, j);
                addentry(digitvalue);
            } else if (Character.isUpperCase(args.charAt(j))) {
                newid = j;
                break;
            } else if (args.charAt(j) == '[' && args.charAt(indexLen - (indexLen - nxtpos)) == '(') {
                boxopen++;
                j = readBrackets(args, indexLen - (indexLen - nxtpos));
            } else if (args.charAt(j) == '[') {
                boxopen++;
                if (boxopen > 0) {
                    if (!brentry.isEmpty()) {
                        addToTempHash();
                        tempindex++;
                    }
                }
                j = readBrackets(args, j);
            } else if (args.charAt(j) == '(') {
                roundopen++;
                if (roundopen > 0) {
                    if (!brentry.isEmpty()) {
                        addToTempHash();
                        tempindex++;
                    }
                }
                j = readBrackets(args, j);
            } else if (args.charAt(j) == ')' && Character.isDigit(args.charAt(indexLen - (indexLen - nxtpos)))) {
                roundopen--;
                j = IsDigit(args, indexLen - (indexLen - nxtpos));
                if (boxopen == 0 && roundopen == 0) {
                    if (!brentry.isEmpty()) {
                        updateentry(brentry, digitvalue);
                        tempindex = tempindex > 0 ? tempindex = tempindex - 1 : 0;
                        if (!templist[tempindex].isEmpty())
                            matchElementToUpdate(this.brentry, this.templist[tempindex]);
                        else {
                            //suffix=0;
                            addToReactPro();
                        }
                    } else
                        updateentry(reactpro[hmrpos][hmcpos], digitvalue);
                } else {
                    updateentry(brentry, digitvalue);
                    tempindex = tempindex > 0 ? tempindex = tempindex - 1 : 0;
                    if (!templist[tempindex].isEmpty())
                        matchElementToUpdate(brentry, templist[tempindex]);
                    else {
                        //suffix=0;
                        addToReactPro();
                    }
                }
            } else if (args.charAt(j) == ']' && Character.isDigit(args.charAt(indexLen - (indexLen - nxtpos)))) {
                boxopen--;
                j = IsDigit(args, indexLen - (indexLen - nxtpos));
                if (boxopen == 0 && roundopen == 0) {
                    if (!brentry.isEmpty()) {
                        updateentry(brentry, digitvalue);
                        tempindex = tempindex > 0 ? tempindex = tempindex - 1 : 0;
                        if (!templist[tempindex].isEmpty())
                            matchElementToUpdate(brentry, templist[tempindex]);
                        else {
                            //suffix=0;
                            addToReactPro();
                        }
                    } else
                        updateentry(reactpro[hmrpos][hmcpos], digitvalue);
                } else {
                    updateentry(brentry, digitvalue);
                    tempindex = tempindex > 0 ? tempindex = tempindex - 1 : 0;
                    if (!templist[tempindex].isEmpty())
                        matchElementToUpdate(this.brentry, this.templist[tempindex]);
                    else {
                        suffix = 0;
                        addToReactPro();
                    }
                }
            } else if (args.charAt(j) == ')') {
                roundopen--;
                if (roundopen == 0 && boxopen == 0)
                    addToReactPro();
                else {
                    tempindex = tempindex > 0 ? tempindex = tempindex - 1 : 0;
                    if (!templist[tempindex].isEmpty())
                        matchElementToUpdate(brentry, templist[tempindex]);
                    else {
                        suffix = 0;
                        addToReactPro();
                    }
                }
            } else if (args.charAt(j) == ']') {
                boxopen--;
                if (roundopen == 0 && boxopen == 0)
                    addToReactPro();
                else {
                    tempindex = tempindex > 0 ? tempindex = tempindex - 1 : 0;
                    if (!templist[tempindex].isEmpty())
                        matchElementToUpdate(brentry, templist[tempindex]);
                    else {
                        suffix = 0;
                        addToReactPro();
                    }
                }
            }
            newid = j;
        }
        return newid;
    }
    //For reading the brackets expression
    private int readBrackets(String args, int idx) {
        for (int i = idx + 1, nxtpos = 0; i < args.length(); i++) {
            nxtpos = calculateNextPosition(i);
            if (Character.isUpperCase(args.charAt(i)) && Character.isUpperCase(args.charAt(indexLen - (indexLen - nxtpos)))) {
                temp = String.valueOf(args.charAt(i));
                addentry(1);
            } else if (Character.isUpperCase(args.charAt(i)) && args.charAt(indexLen - (indexLen - nxtpos)) == '[') {
                temp = String.valueOf(args.charAt(i));
                addentry(1);
                addToTempHash();
                tempindex++;
                boxopen++;
                //suffix=1;
                i = readBrackets(args, indexLen - (indexLen - nxtpos));
            } else if (Character.isUpperCase(args.charAt(i)) && args.charAt(indexLen - (indexLen - nxtpos)) == '(') {
                temp = String.valueOf(args.charAt(i));
                addentry(1);
                addToTempHash();
                tempindex++;
                roundopen++;
                //suffix=1;
                i = readBrackets(args, indexLen - (indexLen - nxtpos));
            } else if (Character.isUpperCase(args.charAt(i)) && args.charAt(indexLen - (indexLen - nxtpos)) == ')') {
                temp = String.valueOf(args.charAt(i));
                addentry(1);
                i = readLower(args, i);
                i = i - 1;
            } else if (Character.isUpperCase(args.charAt(i)) && args.charAt(indexLen - (indexLen - nxtpos)) == ']') {
                temp = String.valueOf(args.charAt(i));
                addentry(1);
                i = readLower(args, i);
                i = i - 1;
            } else if (args.charAt(i) == '(') {
                roundopen++;
                if (!brentry.isEmpty()) {
                    addToTempHash();
                    tempindex++;
                }
                continue;
            } else if (args.charAt(i) == '[') {
                boxopen++;
                if (!brentry.isEmpty()) {
                    addToTempHash();
                    tempindex++;
                }
                continue;
            } else if (Character.isUpperCase(args.charAt(i))) {
                temp = String.valueOf(args.charAt(i));
                i = readLower(args, i);
                i = i - 1;
            }
            newid = i;
        }
        return newid;
    }
    //This function is used for adding elements in the respective hashmap considering whether any box brackets or round brackets
    //are open if not then add the elements to the reactpro hashmap
    private void addentry(int value) {
        if (boxopen > 0) {
            keyexists = brentry.containsKey(temp);
            if (roundopen > 0) {
                if (keyexists == false)
                    brentry.put(temp, value);
                else
                    updateKeyValue(temp, value, brentry);
            } else {
                if (keyexists == false)
                    brentry.put(temp, value);
                else
                    updateKeyValue(temp, value, brentry);
            }
        } else if (roundopen > 0) {
            keyexists = brentry.containsKey(temp);
            if (keyexists == false)
                brentry.put(temp, value);
            else
                updateKeyValue(temp, value, brentry);
        } else {
            keyexists = reactpro[hmrpos][hmcpos].containsKey(temp);
            if (keyexists == false)
                reactpro[hmrpos][hmcpos].put(temp, value);
            else
                updateKeyValue(temp, value, reactpro[hmrpos][hmcpos]);
        }
    }

    //This function are called when the Box or Round brackets opens we are adding it to the templist hashtable
    //when anyother round or box bracket gets opened
    private void addToTempHash() {
        Enumeration keys = brentry.keys();
        while (keys.hasMoreElements()) {
            Object retrievedKey = keys.nextElement();
            templist[tempindex].put(retrievedKey, brentry.get(retrievedKey));
        }
        brentry.clear();
    }
    //For calculating the no of digits after the element.
    private int IsDigit(String args, int idx) {
        String variable = "";
        int newid2 = 0;
        for (int k = idx; k < fullLen; k++) {
            if (Character.isDigit(args.charAt(k))) {
                variable += String.valueOf(args.charAt(k));
                newid2 = k;
            } else {
                newid2 = k - 1;
                break;
            }
        }
        newid = newid2;
        if (variable.equals("") || variable.equals("0"))
            digitvalue = 1;
        else
            digitvalue = Integer.parseInt(variable);
        return newid;
    }
    //For updating the key value stored in the hashtable with that of the value specified after the round or box bracket
    protected void updateentry(Hashtable h, int value) {
        Enumeration keys = h.keys();
        while (keys.hasMoreElements()) {
            Object retrievedKey = keys.nextElement();
            h.put(retrievedKey, (Object) String.valueOf(Integer.parseInt(String.valueOf(h.get(retrievedKey))) * value));
        }
    }
    //This function is called when any box or round brackets gets closed we are updating the brentry hashtable
    //with that of the templist hashtable also checking before adding whether any key exists or not.If exists we are updating the key value
    // with that of brentry hashtable and templist hashtable. And also finally adding it to the final hashtable.
    public void matchElementToUpdate(Hashtable a, Hashtable b) {
        //If a hashmap is empty and the b is not empty then directly copy all the elements from hashmap b to hashmap a
        yesno = a.isEmpty() && !b.isEmpty() ? true : false;
        if (yesno == true)

        {
            Enumeration keys = b.keys();
            while (keys.hasMoreElements()) {
                Object retrievedKey = keys.nextElement();
                a.put(retrievedKey, b.get(retrievedKey));
            }
        } else {
            Enumeration keys1 = a.keys();
            while (keys1.hasMoreElements()) {
                Object retrievedKey1 = keys1.nextElement();
                Enumeration keys2 = b.keys();
                while (keys2.hasMoreElements()) {
                    Object retrievedKey2 = keys2.nextElement();
                    if (a.containsKey(retrievedKey2)) {
                        if (retrievedKey1.equals(retrievedKey2)) {
                            int result = Integer.parseInt(String.valueOf(a.get(retrievedKey1))) + Integer.parseInt(String.valueOf(b.get(retrievedKey2)));
                            a.put(retrievedKey1, (Object) String.valueOf(result));
                            b.remove(retrievedKey2);
                        }
                    } else {
                        a.put(retrievedKey2, b.get(retrievedKey2));
                        b.remove(retrievedKey2);
                    }
                }
            }
        }
        b.clear();
    }
    private void addToReactPro() {
        Enumeration keys = brentry.keys();
        while (keys.hasMoreElements()) {
            Object retrievedKey = keys.nextElement();
            keyexists = reactpro[hmrpos][hmcpos].containsKey(retrievedKey);
            if (keyexists == false)
                reactpro[hmrpos][hmcpos].put(retrievedKey, brentry.get(retrievedKey));
            else {
                int value = Integer.parseInt(String.valueOf(brentry.get(retrievedKey)));
                updateKeyValue(String.valueOf(retrievedKey), value, reactpro[hmrpos][hmcpos]);
            }
        }
        brentry.clear();
    }
    private void updateKeyValue(String key, int newVal, Hashtable h) {
        Enumeration keys = h.keys();
        while (keys.hasMoreElements()) {
            Object retrievedKey = keys.nextElement();
            if (retrievedKey.equals(key)) {
                if (suffix != 0) {
                    h.put(retrievedKey, String.valueOf(Integer.parseInt(String.valueOf(h.get(retrievedKey))) * newVal));
                    suffix = 0;
                } else
                    h.put(retrievedKey, String.valueOf(Integer.parseInt(String.valueOf(h.get(retrievedKey))) + newVal));
                break;
            }
        }
    } //This function will return the atomic weight of that particular element which is stored in the hm hashmap
    //which is acting as a database in our case.
    private double getMolWeight(String key) {
        double value = 0;
        Enumeration keys = hm.keys();
        while (keys.hasMoreElements()) {
            Object retrievedKey = keys.nextElement();
            if (retrievedKey.equals(key)) {
                value = Double.parseDouble(String.valueOf(hm.get(retrievedKey)));
                break;
            }
        }
        return value;
    }
    //For calculating the molecular weight of the expression and for storing the molecular weight as per the compounds
    //in the mol_weight variable at a particular row and at a particular's column
    protected void calculateMolWeight(int rindex, int cindex) {
        finaloutput = 0;
        Enumeration keys = reactpro[rindex][cindex].keys();
        while (keys.hasMoreElements()) {
            Object retrievedKey = keys.nextElement();
            output = getMolWeight(String.valueOf(retrievedKey));
            finaloutput += output * Integer.parseInt(String.valueOf(reactpro[rindex][cindex].get(retrievedKey)));
        }
        outpt2= ("The Molecular mass is:"+finaloutput);
    }
    public void main(String args[]) {
        setInitialValues();
        accept();
    }

    @Override
    public void onClick(View view) {

    }
}