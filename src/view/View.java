package view;

public class View {

	private VentanaPrincipal vPrincipal;
	private FillData vFillData;

	public View() {
		vPrincipal = new VentanaPrincipal();
		vFillData = new FillData();
	}

	public VentanaPrincipal getvPrincipal() {
		return vPrincipal;
	}

	public FillData getvFillData() {
		return vFillData;

	}

	public void setvFillData(FillData f) {
		this.vFillData = f;
	}

}
