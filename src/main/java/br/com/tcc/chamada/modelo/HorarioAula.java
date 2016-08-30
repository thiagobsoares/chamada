package br.com.tcc.chamada.modelo;

public enum HorarioAula {
	t06_00("06:00"), t07_00("07:00"), t08_00("08:00"), t09_00("09:00"), t10_00("10:00"), t11_00("11:00"), t12_00(
			"12:00"), t13_00("13:00"), t14_00("14:00"), t15_00("15:00"), t16_00("16:00"), t17_00("17:00"), t18_00(
					"18:00"), t19_00("19:00"), t20_00("20:00"), t21_00("21:00"), t22_00("22:00"), t23_00("23:00");

	private String hora;

	HorarioAula(String hora) {
		this.hora = hora;
	}

	public String getHora() {
		return hora;
	}
}