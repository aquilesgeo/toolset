package pe.ec.winapi;

import org.junit.Test;

public class DialogTest extends AbstractWinapi{
	@Test
	public void createControlDialog(){
		dialog("IDD_DIALOG", MODAL);
		text("IDC_LOG", "m_log");
		integer("IDC_CODE", "m_code");
	}
	
	@Test
	public void createUserDialog(){
		dialog("IDD_DIALOG", MODAL);
		text("IDC_LOG", "m_log");
		integer("IDC_CODE", "m_code");
	}
}
