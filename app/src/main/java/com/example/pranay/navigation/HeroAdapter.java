package com.example.pranay.navigation;

/**
 * Created by Pranay on 3/21/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import android.database.DatabaseErrorHandler;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.HeroViewHolder> {


    String link,head;
    private DBhelper db;

    private List<Hero> objList;
    private Context context;
    int i;
    //SQLiteDatabase db;

    public HeroAdapter(List<Hero> heroList, Context context) {
        this.objList = heroList;
        this.context = context;
        db = new DBhelper(this.context);
    }

//        public void onSQLCreated( SQLiteDatabase db)
//        {
//            db = SQLiteDatabase.openOrCreateDatabase("book.db",null);
//            db.execSQL("create table if not exists book(headlines Varchar(5000),links Varchar(5000),summ Varchar(5000))");
//        }

    @Override
    public HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_news, parent, false);
        return new HeroViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final HeroViewHolder holder, final int position) {
        final Hero hero = objList.get(position);
        holder.textViewheadlines.setText(hero.getHeadlines());
        //holder.textViewRealName.setText(hero.getRealName());
        //holder.textViewTeam.setText(hero.getTeamName());
        /*holder.textViewFirstAppearance.setText(hero.getFirstApp
        earance());
        holder.textViewCreatedBy.setText(hero.getCreatedBy());
        holder.textViewPublisher.setText(hero.getPublisher());*/
        //holder.textViewBio.setText(hero.getSummary().trim());

        //bookmark news and save it in android sqlite db
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0){
                    holder.imageView.setImageResource(R.drawable.bookmark_icon);
                    i=1;
//                    String summ_b= objList.get(position).getBio();
//                    String link_b=objList.get(position).getLinks();
//                    String head_b=objList.get(position).getHeadlines();
//                    db.execSQL("insert into book(headlines,links,summ) values ('"+head_b+"','"+link_b+"','"+summ_b+"')");

                    long id= db.insertBookmark(link,head);
                    Log.d("test","inserted"+db.getBookmarkCount());
                }
                else{
                    holder.imageView.setImageResource(R.drawable.un_bookmark_icon);
                    i=0;
                    db.deleteBookmark(link,head);
                    Log.d("test","deleted"+db.getBookmarkCount());

                }
            }
        });

        //share link using other apps to other users
        holder.imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                link=objList.get(position).getLinks();
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, link);
                context.startActivity(Intent.createChooser(share,"Share using"));
            }
        });


        holder.textViewheadlines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String summ= objList.get(position).getBio();
                link=objList.get(position).getLinks();
                head=objList.get(position).getHeadlines();
                //Toast.makeText(context, summ , Toast.LENGTH_SHORT).show();

                Intent i = new Intent(context,summary.class);
                i.putExtra("summary",summ);
                i.putExtra("links",link);
                i.putExtra("headlines",head);
                context.startActivity(i);
            }
        });
//        holder.summary.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String summ= heroList.get(position).getBio();
//                //Toast.makeText(context, summ , Toast.LENGTH_SHORT).show();
//
//                Intent i = new Intent(context,summary.class);
//                i.putExtra("summary",summ);
//                context.startActivity(i);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return objList.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {
        TextView textViewheadlines, textViewRealName,summary, textViewTeam, textViewFirstAppearance,
                textViewCreatedBy, textViewPublisher, textViewBio;
        ImageView imageView,imageView1;
        //  LinearLayout linearLayout;

        HeroViewHolder(View itemView) {
            super(itemView);

            textViewheadlines = (TextView) itemView.findViewById(R.id.textViewheadline);
            //textViewRealName = (TextView) itemView.findViewById(R.id.textViewRealName);
            //summary=(TextView) itemView.findViewById(R.id.summ);
            //textViewTeam = (TextView) itemView.findViewById(R.id.te);
            /*textViewFirstAppearance = (TextView) itemView.findViewById(R.id.textViewFirstAppearance);
            textViewCreatedBy = (TextView) itemView.findViewById(R.id.textViewCreatedBy);
            textViewPublisher = (TextView) itemView.findViewById(R.id.textViewPublisher);*/
            //textViewBio = (TextView) itemView.findViewById(R.id.textViewBio);
            imageView = (ImageView) itemView.findViewById(R.id.ib_b);
            imageView1 = (ImageView) itemView.findViewById(R.id.ib_sh);

            //linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}