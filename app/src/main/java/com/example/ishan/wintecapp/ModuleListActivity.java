package com.example.ishan.wintecapp;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.SparseArray;

import android.widget.ExpandableListView;
import android.widget.TextView;


public class ModuleListActivity extends AppCompatActivity {
    SparseArray<Semester> semesters = new SparseArray<Semester>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_list);
        TextView txtInfo = (TextView)findViewById(R.id.txtInfo);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.bg1));
        if(getIntent() != null)
        {
            String info = getIntent().getStringExtra("info");
            txtInfo.setText(info);
        }
        createData();

        ExpandableListView listView = (ExpandableListView) findViewById(R.id.moduleListView);
        final ExpandableListAdapter adapter = new ExpandableListAdapter(this,
                semesters);
        listView.setAdapter(adapter);

//      CardView cw =(CardView) listView.findViewById(R.id.moduleCard);
//              cw.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent=new Intent(ModuleListActivity.this,ModuleActivity.class);
//                 startActivity(intent);
// TextView tx= (TextView) v.findViewById(R.id.mCode);
//
//                Toast.makeText(ModuleListActivity.this, tx.getText().toString(),
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    public void createData() {

        for (int j = 0; j < 6; j++) {
            Semester sem = new Semester("Sem " + j);
            for (int i = 0; i < 4; i++) {
                Module m=new Module("Info-"+i,"Module Title"+i,7,15,"description",true, 1);

                sem.modules.add(m);
            }
            semesters.append(j, sem);
        }
    }
}
