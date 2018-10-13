package com.rcp.mail.project;

import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;


public class MessageTableView extends ViewPart implements ISelectionListener{

	private Table table;
	private TableViewer tableViewer;
	private final WritableValue selectedFolder = new WritableValue();
	private LocalResourceManager resourceManager = new LocalResourceManager(
			JFaceResources.getResources());
	private Color gray;
	private Font italics;

	public static final String ID = "com.ram.mail.project.MessageTableView";
	
	public MessageTableView() {
		// TODO Auto-generated constructor stub
	}

	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout());

		tableViewer = new TableViewer(container, SWT.FULL_SELECTION
				| SWT.MULTI | SWT.BORDER) {
			// The following is a workaround for bug 269264.
			public void remove(Object[] elements) {
				int oldIndex = -1;
				Table table = tableViewer.getTable();
				int[] selectionIndices = table.getSelectionIndices();
				if (selectionIndices.length > 0) {
					oldIndex = selectionIndices[0];
				}
				super.remove(elements);
				if (oldIndex != -1) {
					if (table.getItemCount() > oldIndex) {
						table.setSelection(oldIndex);
					} else if (table.getItemCount() > 0) {
						table.setSelection(table.getItemCount() - 1);
					}
				}
				setSelection(getSelection(), false);
			}
		};
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		TableViewerColumn columnFrom = new TableViewerColumn(tableViewer, SWT.NONE);
		columnFrom.getColumn().setWidth(95);
		columnFrom.getColumn().setText("From");
		
		TableViewerColumn columnSubject = new TableViewerColumn(tableViewer, SWT.NONE);
		columnSubject.getColumn().setWidth(300);
		columnSubject.getColumn().setText("Subject");
		
		TableViewerColumn columnDate = new TableViewerColumn(tableViewer, SWT.NONE);
		columnDate.getColumn().setWidth(85);
		columnDate.getColumn().setText("Date");
		
	}

	@Override
	public void setFocus() {
       tableViewer.getTable().setFocus();
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		
	}

}
