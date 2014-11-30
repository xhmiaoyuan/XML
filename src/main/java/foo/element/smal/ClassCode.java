package foo.element.smal;

public class ClassCode {

	String Type;
	String text;
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "ClassCode [Type=" + Type + ", text=" + text + "]";
	}
	
}
