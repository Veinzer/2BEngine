package local.twobengine.engine.event;

import java.awt.Color;
import java.util.concurrent.TimeUnit;
import local.twobengine.engine.window.component.ButtonComponent;
import local.twobengine.engine.window.component.Component;

public class ButtonClickEvent extends Event {
	
	private String name;
	private Component component;

	public ButtonClickEvent(String name, Component component) {
		super();
		this.name = name;
		this.component = component;
		hoverClick();
	}
	
	public void hoverClick(){
		if(component instanceof ButtonComponent) {
			ButtonComponent buttonComponent = (ButtonComponent) component;
			

				Color defaultColor = buttonComponent.getColor();
				Color hoverColor = buttonComponent.getHoverColor();
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					buttonComponent.setColor(hoverColor);
	
					try {
						
						
						Thread.sleep(TimeUnit.SECONDS.toMillis(1));
	
						buttonComponent.setColor(defaultColor);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
				}
			});
		
			if(!(buttonComponent.getColor() == hoverColor)) {
			thread.start();
			}
		}else {
				System.out.println("test");
			}
		
	}

	
	public String getName() {
		return name;
		
	}
	
	public Component getComponent() {
		return component;
	}


}
