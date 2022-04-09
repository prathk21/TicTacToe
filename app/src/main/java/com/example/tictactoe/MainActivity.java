package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
      //0-0
       // X-1;
    int playerTurn = 0;
    boolean gameIsOn = true;
    int grid[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    // -1 represent in empty cell in grid
    // 0 represent 'O' in cell
    // 1 represent  'X' in cell
    int winningPosssibility[][] ={{0,1,2,},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};






    public void clickOnCell(View view)
    {
        if(!gameIsOn)
            startAgain();
        ImageView image  = (ImageView)view;
        int cellNumber  = Integer.parseInt(image.getTag().toString());
        TextView textView = findViewById(R.id.textView2);
        if(grid[cellNumber]==-1)
        {
            grid[cellNumber] = playerTurn;


            if(playerTurn==0)
            {
                image.setImageResource(R.drawable.o);
                playerTurn= 1;
                textView.setText("X's Turn");
            }
            else
            {
                image.setImageResource(R.drawable.cross);
                playerTurn= 0;
                textView.setText("0's Turn");
            }
        }

        for(int positions[] :winningPosssibility)
        {
            if(grid[positions[0]]!=-1&&grid[positions[0]]==grid[positions[1]]&&grid[positions[1]]==grid[positions[2]])
            {
                 if(grid[positions[0]]==0)
                 {
                   //  textView.setText("0! has won the game");
                     gameIsOn  = false;
                     AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                     builder1.setMessage("0! has won the game");
                     builder1.setCancelable(true);

                     builder1.setPositiveButton(
                             "Play Again",
                             new DialogInterface.OnClickListener() {
                                 public void onClick(DialogInterface dialog, int id) {
                                     dialog.cancel();
                                 }
                             });
                     AlertDialog alert11 = builder1.create();
                     alert11.show();
                     startAgain();
                 }
                 else
                 {
                   //  textView.setText("X! has won the game");

                     gameIsOn  = false;
                     AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                     builder1.setMessage("X! has won the game");
                     builder1.setCancelable(true);

                     builder1.setPositiveButton(
                             "Play Again",
                             new DialogInterface.OnClickListener() {
                                 public void onClick(DialogInterface dialog, int id) {
                                     dialog.cancel();
                                 }
                             });
                     AlertDialog alert11 = builder1.create();
                     alert11.show();
                     startAgain();
                 }

            }
        }

        boolean checkEmpty= false;
        for(int i=0;i<grid.length;i++)
        {
            if(grid[i]==-1) {
                checkEmpty = true;
                break;
            }
        }
        if(!checkEmpty&&gameIsOn)
        {
            gameIsOn= false;
              AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Game is draw");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Play Again",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();
            startAgain();
           
        }


    }

    private void startAgain() {
        for(int i=0;i<grid.length;i++)
            grid[i]= -1;
        setCellToEmpty();
        gameIsOn = true;
        playerTurn = 0;
    }

    private void setCellToEmpty() {
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
