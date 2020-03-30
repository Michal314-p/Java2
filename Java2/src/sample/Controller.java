package sample;

import cw_sort.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.*;

public class Controller implements Initializable {

   ObservableList<String> algorithms= FXCollections.observableArrayList("Quick sort","Insertion sort","Counting sort");
   public List<IElement> list0 =new ArrayList<>();
   public List<IntElement> list1=new ArrayList<>();

   public Button Sort;
   public Menu app_desc;
   public Menu app_language;
   public Label int_label;
   public Label float_label;
   public Button add;
   public Button add1;
   public Label desc;
   public Label place;
   public Label stabl;
   public Label desc_lang;
   public Label place_lang;
   public Label stabl_lang;
   public Button show1;
   public Button show2;
   public Label choose_alg;
   public TextField add_name;
   public TextField addName1;
   public TextField add_value;
   public TextField addValue1;
   public ComboBox algorithm;
   public ListView<String> listView;
   public Label datttt;
   public Label inform;

   public ResourceBundle bundle;
   public Locale locale;

   public void add_float()
   {
      try
      {
         list0.add(new FloatElement(addName1.getText(),Float.parseFloat(addValue1.getText())));
      }
      catch (NumberFormatException e)
      {
         listView.getItems().clear();
         listView.getItems().add("Not a valid input");
      }


   }

   public void add_integer()
   {
      try
      {
         list1.add(new IntElement(add_name.getText(), Integer.parseInt(add_value.getText())));
      }
      catch (NumberFormatException e)
      {
         listView.getItems().clear();
         listView.getItems().add("Not a valid input");
      }
   }

   public void sort()
   {
      listView.getItems().clear();
      if(algorithm.getSelectionModel().getSelectedItem().toString()=="Quick sort")
      {
         Quick sorter = new Quick();
         List<IElement> sorted = sorter.solve1(list0);
         for(int i = 0; i < list0.size(); i++)
         {
            String wyswietl = sorted.get(i).getValue() + " - " + list0.get(i).getName();
            listView.getItems().add(wyswietl);
         }
         desc.setText(sorter.desc);
         stabl.setText(String.valueOf(sorter.stability));
         place.setText(String.valueOf(sorter.in_place));
      }

      if(algorithm.getSelectionModel().getSelectedItem().toString()=="Insertion sort")
      {
         Insert sorter = new Insert();
         List<IElement> sorted = sorter.solve1(list0);
         for(int i = 0; i < list0.size(); i++)
         {
            String wyswietl = sorted.get(i).getValue() + " - " + list0.get(i).getName();
            listView.getItems().add(wyswietl);
         }
         desc.setText(sorter.desc);
         stabl.setText(String.valueOf(sorter.stability));
         place.setText(String.valueOf(sorter.in_place));
      }

      if(algorithm.getSelectionModel().getSelectedItem().toString()=="Counting sort")
      {
         Counting sorter = new Counting();
         List<IntElement> sorted = sorter.solve0(list1);
         for(int i = 0; i < list1.size(); i++)
         {
            String wyswietl = sorted.get(i).getValue() + " - " + list1.get(i).getName();
            listView.getItems().add(wyswietl);
         }
         desc.setText(sorter.desc);
         stabl.setText(String.valueOf(sorter.stability));
         place.setText(String.valueOf(sorter.in_place));
      }
   }

   public void bGB()
   {
      language("en_GB");
      Locale.setDefault(Locale.UK);
      datttt.setText(date_set(Locale.getDefault()));

   }

   public void bUS()
   {
      language("en_US");
      Locale.setDefault(Locale.US);
      datttt.setText(date_set(Locale.getDefault()));
   }

   public void bES()
   {
      language("es_ES");
      Locale.setDefault(Locale.GERMANY);
      datttt.setText(date_set(Locale.getDefault()));
   }

   public void bPL()
   {
      language("pl_PL");
      Locale.setDefault(Locale.GERMANY);
      datttt.setText(date_set(Locale.getDefault()));
   }



   public void show0()
   {
      listView.getItems().clear();
      for(int i = 0; i < list0.size(); i++)
      {
         Float val = list0.get(i).getValue();
         String wyswietl = decimal_sep(Locale.getDefault(),val) + " - " + list0.get(i).getName();
         listView.getItems().add(wyswietl);
      }
   }

   public void show1()
   {
      listView.getItems().clear();
      for(int i = 0; i < list1.size(); i++)
      {
         String wyswietl = list1.get(i).getValue() + " - " + list1.get(i).getName();
         listView.getItems().add(wyswietl);
      }
   }

   public void language(String lang)
   {
      locale = new Locale(lang);
      bundle = ResourceBundle.getBundle("sample.language", locale);
      app_desc.setText(bundle.getString("app_desc"));
      app_language.setText(bundle.getString("app_language"));
      int_label.setText(bundle.getString("int_label"));
      float_label.setText(bundle.getString("float_label"));
      desc_lang.setText(bundle.getString("desc_lang"));
      place_lang.setText(bundle.getString("place_lang"));
      stabl_lang.setText(bundle.getString("stabl_lang"));
      show1.setText(bundle.getString("show1"));
      show2.setText(bundle.getString("show2"));
      choose_alg.setText(bundle.getString("choose_alg"));
      add_name.setPromptText(bundle.getString("add_name"));
      addName1.setPromptText(bundle.getString("addName1"));
      add_value.setPromptText(bundle.getString("add_value"));
      addValue1.setPromptText(bundle.getString("addValue1"));
      add.setText(bundle.getString("add"));
      add1.setText(bundle.getString("add1"));
      Sort.setText(bundle.getString("Sort"));


   }

   String decimal_sep(Locale loc, Float val)
   {
      System.out.println(val);
      String pattern = "";
      NumberFormat nf = NumberFormat.getNumberInstance(loc);
      DecimalFormat df = (DecimalFormat)nf;
      df.applyPattern(pattern);
      String output = df.format(val);
      return output;
   }

   static String date_set(Locale locale)
   {
      DateFormat formatter=DateFormat.getDateInstance(DateFormat.DEFAULT,locale);
      Date currentDate=new Date();
      String date=formatter.format(currentDate);
      return date;
   }

   public void about_app()
   {
      listView.getItems().clear();
      listView.getItems().add("Program sortujący liczby za pomocą różnych algorytmów");
   }

   public void initialize(URL url, ResourceBundle resourceBundle)
   {

      algorithm.setItems(algorithms);
   }
}
