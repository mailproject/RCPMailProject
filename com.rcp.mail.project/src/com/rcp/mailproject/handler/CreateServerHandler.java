package com.rcp.mailproject.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;


public class CreateServerHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
//		WizardDialog dialog = new WizardDialog(HandlerUtil.getActiveWorkbenchWindow(event).getShell(),
//				new CreateServerWizard());
//		dialog.open();
		return null;
	}

}
