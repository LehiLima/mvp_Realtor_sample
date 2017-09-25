package lehilima.zapmoveis_teste.view;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import butterknife.Bind;
import butterknife.ButterKnife;
import lehilima.zapmoveis_teste.Custom.CustomDialogSendMessage;
import lehilima.zapmoveis_teste.Custom.CustomDialogSucessFail;
import lehilima.zapmoveis_teste.R;
import lehilima.zapmoveis_teste.Util.Util;
import lehilima.zapmoveis_teste.contract.DetailImovelActivityContract;
import lehilima.zapmoveis_teste.data.model.Imovel;
import lehilima.zapmoveis_teste.data.network.DataManager;
import lehilima.zapmoveis_teste.presenter.DetailImovelPresenter;

public class DetailImovelActivity extends AppCompatActivity implements DetailImovelActivityContract.View{

    private static Imovel mIimovel;

    private DetailImovelActivityContract.Presenter mPresenter;
    private NumberFormat nf = NumberFormat.getCurrencyInstance();

    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;

    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Bind(R.id.valor)
    TextView mValor;

    @Bind(R.id.subtipo)
    TextView mSubTipo;

    @Bind(R.id.endereco)
    TextView mEndereco;

    @Bind(R.id.dorms)
    TextView mDorms;

    @Bind(R.id.suites)
    TextView mSuites;

    @Bind(R.id.vagas)
    TextView mVagas;

    @Bind(R.id.area)
    TextView mArea;

    @Bind(R.id.observacao)
    TextView mObservacao;

    @Bind(R.id.caracteristicas)
    TextView mCaracteristicas;

    @Bind(R.id.outrascaracteristicas)
    TextView mOutrasCaracteristicas;

    @Bind(R.id.dtAtualizacao)
    TextView mDataAtualização;

    @Bind(R.id.pageindicator)
    TextView mPageIndicator;

    @Bind(R.id.destaque)
    TextView mDestaque;

    @Bind(R.id.loading_screen)
    LinearLayout loading_screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detail_imovel);
        overridePendingTransition(R.anim.alpha_out_right ,R.anim.alpha_in_left);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);

        loading_screen.setVisibility(View.VISIBLE);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callDialog();
            }
        });

        //retrieve de select item
        int lImovel = getIntent().getExtras().getInt("idImovel");
        mPresenter = new DetailImovelPresenter(DataManager.getInstance(this),this);
        mPresenter.getImovel(lImovel);

    }

    private void populateDetail() {
        try {
            String valor = nf.format(Double.parseDouble(mIimovel.getPrecoVenda().toString()));
            valor = valor.replace(",00","");
            mValor.setText(valor);
            mSubTipo.setText(mIimovel.getSubtipoImovel().toString());
            mEndereco.setText(mIimovel.getEndereco().getLogradouro().toString());
            mDorms.setText(mIimovel.getDormitorios().toString());
            mSuites.setText(mIimovel.getSuites().toString());
            mVagas.setText(mIimovel.getVagas().toString());
            mArea.setText(mIimovel.getAreaTotal().toString());
            mObservacao.setText(mIimovel.getObservacao().toString());
            mCaracteristicas.setText(mIimovel.getCaracteristicas().toString());
            mOutrasCaracteristicas.setText(mIimovel.getCaracteristicasComum().toString());
            mDataAtualização.setText(Util.convertDate(mIimovel.getDataAtualizacao().toString()));
            mPageIndicator.setText(("1 de " + mIimovel.getFotos().size()));

            if (mIimovel.getSubTipoOferta().equals("Normal")){
                mDestaque.setHeight(15);
                mDestaque.getLayoutParams().height = 15;
                mDestaque.setBackgroundColor(this.getResources().getColor(R.color.colorPrimary));
            }
            mDestaque.setText(mIimovel.getSubTipoOferta().toString());
            mDestaque.setVisibility(View.VISIBLE);
        }catch (Exception e){
            Log.e("Erro", e.toString());
        }
    }


    private void callDialog() {
        CustomDialogSendMessage cdd=new CustomDialogSendMessage(this,this);
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        cdd.getWindow().getAttributes().windowAnimations = R.style.animationdialog;
        cdd.show();
    }

    @Override
    public void ShowImovel(Imovel imovel) {
        mIimovel = imovel;
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mPageIndicator.setText((position + 1) + " de " + mIimovel.getFotos().size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        populateDetail();
        loading_screen.setVisibility(View.GONE);
    }

    @Override
    public void ShowEmpty() {
        loading_screen.setVisibility(View.GONE);
        String message = getResources().getString(R.string.missing_data);
        CustomDialogSucessFail cdd=new CustomDialogSucessFail(this,this,message,R.drawable.warning);
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        cdd.getWindow().getAttributes().windowAnimations = R.style.animationdialog;
        cdd.show();
    }
    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {


        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private int mPosition;

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber -1);
            fragment.setArguments(args);

            return fragment;
        }
        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            initArguments();
        }

        private void initArguments() {
            final Bundle arguments = getArguments();
            if(arguments != null) {
                mPosition = arguments.getInt(ARG_SECTION_NUMBER);
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_images_imovel_detail, container, false);
            ImageView imageView = (ImageView) rootView.findViewById(R.id.imovel_fotos);
            Picasso.with(rootView.getContext())
                    .load(mIimovel.getFotos().get(mPosition).replace("http","https"))
                    .fit()
                    .error(R.drawable.ic_crop_original_grey_24dp)
                    .into(imageView);

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {

            return mIimovel.getFotos().size();
        }


    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    public void showSuccess() {
        String message = getResources().getString(R.string.send_sucess);
        CustomDialogSucessFail cdd=new CustomDialogSucessFail(this,this,message,R.drawable.enviado_icon);
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        cdd.getWindow().getAttributes().windowAnimations = R.style.animationdialog;
        cdd.show();

    }

    @Override
    public void showFail() {
        String message = getResources().getString(R.string.send_error);
        CustomDialogSucessFail cdd=new CustomDialogSucessFail(this,this,message,R.drawable.warning);
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        cdd.getWindow().getAttributes().windowAnimations = R.style.animationdialog;
        cdd.show();
    }
}
