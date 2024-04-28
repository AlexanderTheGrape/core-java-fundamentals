

public non-sealed class JSONString extends JSONObject {
	private String key;
	private String value;
	
	public JSONString(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	
	public String getValue() {
		return value;
	}
	
	
	public static void main(String[] args) {
		JSONString myJsonStr = new JSONString("somekey", "someValue");
		System.out.println(myJsonStr.getKey());
		System.out.println(myJsonStr.getValue());
	}
}