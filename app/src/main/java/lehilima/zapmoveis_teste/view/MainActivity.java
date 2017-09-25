package lehilima.zapmoveis_teste.view;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.constraint.solver.SolverVariable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lehilima.zapmoveis_teste.Custom.CustomDialogSucessFail;
import lehilima.zapmoveis_teste.R;
import lehilima.zapmoveis_teste.Util.Util;
import lehilima.zapmoveis_teste.contract.MainActivityContract;
import lehilima.zapmoveis_teste.data.model.Imoveis;
import lehilima.zapmoveis_teste.data.model.Imovel;
import lehilima.zapmoveis_teste.data.network.DataManager;
import lehilima.zapmoveis_teste.presenter.MainActivityPresenter;
import lehilima.zapmoveis_teste.view.adapter.ListImovelAdapter;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{

    private Imoveis mImoveis;
    private MainActivityContract.Presenter mPresenter;

    @Bind(R.id.loading_screen)
    LinearLayout loading_screen;

    @Bind(R.id.menu_main)
    ImageView mMenuMain;

    @OnClick(R.id.menu_main)
    public void filterMenu() {
        final PopupMenu popupMenu = new PopupMenu(this, mMenuMain);
        final Menu menu = popupMenu.getMenu();
        popupMenu.getMenuInflater().inflate(R.menu.menu_main2, menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Handle item selection
                switch (item.getItemId()) {
                    case R.id.ordenar_por_preco:
                        //order by value
                        Collections.sort(mImoveis.getImoveis(), new orderbyValorComparator());
                        poulateListImoveis();
                        return true;
                    case R.id.ordenar_por_vaga:
                        Collections.sort(mImoveis.getImoveis(), new orderbyVagasComparator());
                        poulateListImoveis();
                        return true;
                    case R.id.ordenar_por_suite:
                        Collections.sort(mImoveis.getImoveis(), new orderbySuiteComparator());
                        poulateListImoveis();
                        return true;
                    default:
                        return true;
                }
            }
        });
        popupMenu.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        loading_screen.setVisibility(View.VISIBLE);
        ckeckConnection();

        overridePendingTransition(R.anim.alpha_out_right ,R.anim.alpha_in_left);
        mPresenter = new MainActivityPresenter(DataManager.getInstance(this),this);
        mPresenter.getImoveis();



    }

    @Override
    public void ShowImoveis(Imoveis imoveis) {
        mImoveis = imoveis;
        poulateListImoveis();
        loading_screen.setVisibility(View.GONE);
    }

    @Override
    public void ShowEmpty() {
        String message = getResources().getString(R.string.missing_data);
        CustomDialogSucessFail cdd=new CustomDialogSucessFail(this,this,message,R.drawable.warning);
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        cdd.getWindow().getAttributes().windowAnimations = R.style.animationdialog;
        cdd.show();
    }


    private void poulateListImoveis() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.list_imoveis);
        ListImovelAdapter mAdapter;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new ListImovelAdapter(mImoveis,this,this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void ckeckConnection() {
        if (!Util.isOnline(this)){
            CustomDialogSucessFail cdd=new CustomDialogSucessFail(this,this, getResources().getString(R.string.connection_error),R.drawable.warning);
            cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            cdd.getWindow().getAttributes().windowAnimations = R.style.animationdialog;
            cdd.show();
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main2, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
//            case R.id.help:
//                showHelp();
//                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    //order by vlue
    class orderbyValorComparator implements Comparator<Imovel>
    {
        public int compare(Imovel left, Imovel right) {
            return right.getPrecoVenda().compareTo(left.getPrecoVenda());
        }

    }

    //order by vagas
    class orderbyVagasComparator implements Comparator<Imovel>
    {
        public int compare(Imovel left, Imovel right) {
            return right.getVagas().compareTo(left.getVagas());
        }

    }

    //order by vagas
    class orderbySuiteComparator implements Comparator<Imovel>
    {
        public int compare(Imovel left, Imovel right) {
            return right.getSuites().compareTo(left.getSuites());
        }

    }
}
