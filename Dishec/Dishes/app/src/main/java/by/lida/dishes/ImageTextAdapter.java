package by.lida.dishes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ImageTextAdapter extends BaseAdapter {

    class ImageStruct{

        private String text;
        private Integer id;

        public Integer getId() {
            return id;
        }

        public String getText() {
            return text;
        }

        public ImageStruct(String text, Integer id) {
            this.text = text;
            this.id = id;
        }
    }

    private List<ImageStruct> imagesId = new ArrayList<ImageStruct>(){{
        add(new ImageStruct("Десерты" ,R.drawable.deserts));
        add(new ImageStruct("Добавки", R.drawable.dobavki));
        add(new ImageStruct("Лапша", R.drawable.lapsha));
        add(new ImageStruct("Напитки", R.drawable.deserts));
        add(new ImageStruct("Пицца", R.drawable.pizza));
        add(new ImageStruct("Роллы", R.drawable.rolls));
        add(new ImageStruct("Салаты", R.drawable.salat));
        add(new ImageStruct("Сеты", R.drawable.set));
        add(new ImageStruct("Шашлыки", R.drawable.shashlik));
        add(new ImageStruct("Супы", R.drawable.sup));
        add(new ImageStruct("Суши", R.drawable.sushi));
        add(new ImageStruct("Теплое", R.drawable.teploye));
        add(new ImageStruct("Закуски", R.drawable.zakuski));
    }};

    private Context mContext;

    public ImageTextAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return imagesId.size();
    }

    @Override
    public Object getItem(int i) {
        return imagesId.get(i).getId();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View grid;
        if(view == null){
            grid = new View(mContext);
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            grid = inflater.inflate(R.layout.cell_grid, viewGroup, false);
        }
        else{
            grid = view;
        }

        ImageView imageView = (ImageView) grid.findViewById(R.id.catalog_image);
        TextView textView = (TextView) grid.findViewById(R.id.catalog_text);
        imageView.setImageResource(imagesId.get(i).getId());
        textView.setText(imagesId.get(i).getText());

        return grid;
    }
}
