package view;

public class View {

	private VentanaPrincipal vPrincipal;
	private FillData vFillData;
	private FillDataGame vFillDataGame; 
	

	public View() {
		vPrincipal = new VentanaPrincipal();
		vFillData = new FillData();
		vFillDataGame = new FillDataGame(); 
	}

	public FillDataGame getvFillDataGame() {
		return vFillDataGame;
	}

	public void setvFillDataGame(FillDataGame vFDataGame) {
		this.vFillDataGame = vFDataGame;
	}

	public void setvPrincipal(VentanaPrincipal vPrincipal) {
		this.vPrincipal = vPrincipal;
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
