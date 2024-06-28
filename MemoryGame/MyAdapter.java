package Filip.Milovanovic.MemoryGame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;




public class MyAdapter extends BaseAdapter {
    private ArrayList<Model> listaElemenata;
    private Context mContext;
//    private int brojac = 0;


    public MyAdapter(Context mContext) {
        this.mContext = mContext;
        listaElemenata = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return listaElemenata.size();
    }

    @Override
    public Object getItem(int i) {
        Object o = null;
        try{
            o = listaElemenata.get(i);
        }catch (Exception e){
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    public void addElement(Model m){
        listaElemenata.add(m);
        notifyDataSetChanged();
    }

    public String getElementUserNameById(int i){
        String el = listaElemenata.get(i).getText11();
        return el;
    }



    public void removeElementByPosition(int pos){
        listaElemenata.remove(pos);
        notifyDataSetChanged();
    }

    public String getBestResult(String userN, int pos){
        String bestScore;
        if(getElementUserNameById(pos).equals(userN)) {
            bestScore = listaElemenata.get(pos).getText31();

            return bestScore;
        }
        else
          return "ERROR 404!!";
    }

    public void update(Model[] players) {
        listaElemenata.clear();
        if(players != null) {
            for(Model player : players) {
                listaElemenata.add(player);
            }
        }

        notifyDataSetChanged();
    }

   public ArrayList<String> getResults(String username){
        ArrayList<String> scores = new ArrayList<>();
        int listSize = getCount();
        for(int i = 0; i < listSize; i++){
            if(listaElemenata.get(i).getText11().equals(username)){
                String newRes = listaElemenata.get(i).getText31();
                scores.add(newRes);
            }
        }
        return scores;
   }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row, null);


            viewHolder = new ViewHolder();
            viewHolder.tv11 = view.findViewById(R.id.row_text11);
            viewHolder.tv12 = view.findViewById(R.id.row_text12);
            viewHolder.tv21 = view.findViewById(R.id.row_text21);
            viewHolder.tv22 = view.findViewById(R.id.row_text22);
            viewHolder.tv31 = view.findViewById(R.id.row_text31);
            viewHolder.tv32 = view.findViewById(R.id.row_text32);
            viewHolder.btn = view.findViewById(R.id.row_btn);
//            viewHolder.ajdi = brojac;
//            brojac += 1;



            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();

        }

        Model el = (Model) getItem(i);
        viewHolder.tv11.setText(el.getText11());
        viewHolder.tv12.setText(el.getText12());
        viewHolder.tv21.setText(el.getText21());
        viewHolder.tv22.setText(el.getText22());
        viewHolder.tv31.setText(el.getText31());
        viewHolder.tv32.setText(el.getText32());






        viewHolder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                removeElementByPosition(viewHolder.ajdi);

                removeElementByPosition(i);
            }
        });

        return view;
    }

    static class ViewHolder{
       TextView tv11,tv12,tv21,tv22,tv31,tv32;
       Button btn;
//       int ajdi;
    }
}
