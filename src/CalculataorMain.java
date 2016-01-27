


	/**Date : 18-10-2009
	 * 
	 * Name : MD. Facihul Azam
	 * Student ID : 0361755
	 * 
	 */
	import java.applet.Applet;
	import java.awt.*;


	class BadOperationException extends Exception
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String label;
		BadOperationException() 
		{
			label = "E";
		}
	}

	public class CalculataorMain extends Applet 
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		TextField result;   /* create text field  */
	  /* Button creation */ 
		Button add;
		Button subtract;
		Button multiply ;
		Button division;
		Button power;
		Button pi;
		Button sine;
		Button arcsine;
		Button equals;
		Button memorystore;
		Button memoryrestore;
		Button clear;
		Button lastOperation;
		Button exp;
		Button sqrt;
		
		float current = 0 , mem=0;
		float f;
			
		/*  init() is always run when the applet is started */
		public void init()
		{
			result = new TextField(20);   /* object creation   */
			add(result);         /*  */
			clear = new Button("Clear");
			add(clear);
			add = new Button("+");
			add(add);
			subtract = new Button("-");
			add(subtract);
			multiply = new Button("*");
			add(multiply);
			division = new Button("/");
			add(division);
			power = new Button("x^y");
			add(power);
			pi = new Button("pi");
			add(pi);
			sqrt = new Button("sqrt");
			add(sqrt);
			sine = new Button("sin");
			add(sine);
			arcsine = new Button("sin-1");
			add(arcsine);
			exp = new Button("e");
			add(exp);
			equals = new Button("=");
			add(equals);
			memorystore= new Button("Ms");
			add(memorystore);
			memoryrestore= new Button("Mr");
			add(memoryrestore);
			lastOperation = null;
		
		}

		/*  Do the work */
			public boolean action(Event event, Object arg)
		{
			
			try {
				if ((event.target == add) ||
					(event.target == subtract)||(event.target == multiply) ||
					(event.target == division)||(event.target == power)||
					(event.target == memorystore))
				{
					completeOperation();
					lastOperation = (Button) event.target;
					result.setText("");       /*set text field blank */
					
				} 
				else if (event.target == equals) 
				{
					completeOperation();
					lastOperation = null;
					String text = Float.toString(current);
					result.setText(text);
				
				}
				else if (event.target == pi)   /* generates pi = 3.14....  approximately */
				{
					 
					double d = Math.PI;
					result.setText(String.valueOf(d));
					
				}
				else if (event.target == exp) /* prints the exponential  */
				{
					double d = Math.E;
					result.setText(String.valueOf(d));
				}
				else if (event.target == sqrt) /* prints the squre root of a number  */
				{
					String text = result.getText();
					Float value = Float.valueOf(text);
					double d = value.floatValue();
					text = String.valueOf (Math.sqrt(d));
					result.setText(text);
				}
				else if (event.target == sine )   /* finds the sin valeu in RADIANS */
				{
					String text = result.getText();
					Float value = Float.valueOf(text);
					double d = value.floatValue();
					text = String.valueOf (Math.sin(d));
					result.setText(text);
					
				}
				else if (event.target == arcsine )  /* finds the arcsin valeu in RADIANS*/
				{
					String text = result.getText();
					Float value = Float.valueOf(text);
					double d = value.floatValue();
					text = String.valueOf (Math.asin(d));
					result.setText(text);
					
				}
					else if (event.target == memoryrestore)  /* Recall the stored number in the text field*/
				{
				
			     	result.setText(Float.toString(current));
					
				}
				else if (event.target == clear) /* cleans the text field */
				{
					current = 0;
					lastOperation = null;
					result.setText("");
					
				}
			} 
			catch (BadOperationException e) /* if an error encounters, shows E for error */
			{
				lastOperation = null;
				result.setText(e.label);
			}		
			return true;
		}

	 /*  do Mathematical operation  */		
		void completeOperation() throws BadOperationException 
		 {
			String text = result.getText();
			Float value;
			try 
			{
				value = Float.valueOf(text);
			} 
			catch (java.lang.NumberFormatException ne) 
			{
				BadOperationException oe = new BadOperationException();
				throw oe;
			}
			
			f = value;
			if (lastOperation == add) {current += f; }  /* adds two values */
			else if (lastOperation == subtract) {current -= f;} /* sutracts */
			else if (lastOperation == multiply) {current *= f ;} /* multiplies two values */
			else if (lastOperation == division) {current /=f; } /* divides */
			else if (lastOperation == memorystore) {current = f;} /* stores a number in memory */
		    else if (lastOperation == power) /* raise x to power y */
			 {
				double d = Math.pow((double)current,(double)f);
				current = (float)d; 
				
			 }	
		    else if (lastOperation == null) /* if no operation happens */
		     {		
				 current = f; 
				
		     }
					
		 }

	}

