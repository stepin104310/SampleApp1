package com.example.sampleapp1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sampleapp1.model.Note;
import com.example.sampleapp1.R;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    final LayoutInflater mLayoutInflater;
    final ArrayList<Note> noteArrayList;

    public NotesAdapter(Context context, ArrayList<Note> notes) {
        noteArrayList = notes;
        mLayoutInflater = LayoutInflater.from(context);
    }

    /**
     * Called when RecyclerView needs a new {@link RecyclerView.ViewHolder} of the given type to represent
     * an item.
     * <p>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p>
     * The new ViewHolder will be used to display items of the adapter using
     * . Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     */
    @NonNull
    @Override   //Buy the planks -- sachin
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View notePlank = mLayoutInflater.inflate(R.layout.row_layout_listview,parent,false);
        return new NotesViewHolder(notePlank);  //sachin is passing the plank to shikar
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the  to reflect the item at the given
     * position.
     * <p>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use  which will
     * have the updated adapter position.
     * <p>
     * Override  instead if Adapter can
     * handle efficient partial bind.
     *
     * @param position The position of the item within the adapter's data set.
     */
    @Override       //Write on planks - shikhar
    public void onBindViewHolder(@NonNull NotesViewHolder plankGivenSachin, int position) {
        Note note = noteArrayList.get(position);
        String title = note.getTitle();
        String subTitle = note.getSubTitle();

        plankGivenSachin.titleTextView.setText(title);
        plankGivenSachin.subTitleTextView.setText(subTitle);
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override   //keep count of the data items -- sohail
    public int getItemCount() {
        return noteArrayList.size();
    }

    //box holding the planks(new or recycled) bought by sachin
    public class NotesViewHolder extends RecyclerView.ViewHolder {
        public final TextView titleTextView;
        public final TextView subTitleTextView;
        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView =itemView.findViewById(R.id.textViewTitle);
            subTitleTextView =itemView.findViewById(R.id.textViewSubtitle);
        }
    }
}
