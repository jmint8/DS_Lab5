import java.util.Stack;

public class History
{

	public Stack<Event> RedoStack = new Stack<>();
	public Stack<Event> UndoStack = new Stack<>();

    /**
       Notepad will call this function when thier text changes.

       deletion is a boolean that indicates if the action was a deletion of text or the insertion of text.
       position is the postion where the change took place
       Change is the string of characters that is the change.
     */
   public void addEvent(boolean deletion, int position, String Change)
   {
	   Event A = new Event(deletion,position,Change);
	   UndoStack.push(A);
	   RedoStack.clear();
   }


    /**
       Notepad will call this function when it wishes to undo the last event.

       note is a variable to the Notepad that called this function
     */
   public void undoEvent(NotePad note)
   {
	   if(UndoStack.isEmpty()==false)
	   {
		   Event A = UndoStack.pop();
		   if(A.deletion = true)
		   {
			   note.insert(A.position, A.change);
		   }
		   else
		   {
			   note.remove(A.position, A.change.length());
		   }
		   RedoStack.push(A);
	   }
	   
	   
   }


    /**
       Notepad will call this function when it wishes to redo the last event that was undone.
       Note that new actions should clear out events that can be "redone"
       note is a variable to the Notepad that called this function
     */
   public void redoEvent(NotePad note)
   {
	   
	   if(RedoStack.isEmpty()==false)
	   {
		   Event B = RedoStack.pop();
		   if(B.deletion == true)
		   {
			   note.remove(B.position, B.change.length());
		   }
		   else
		   {
			   note.insert(B.position, B.change);
		   }
		   UndoStack.push(B);
	   }
	   
   }

    /**
       returns true if there is undo data in the History
     */
   public boolean hasUndoData()
   {
       return (UndoStack.isEmpty()==false);
   }

    /**
       returns true if there is redo data in the History
     */
   public boolean hasReDoData()
   {
       return (RedoStack.isEmpty()==false);
   }
	

}
