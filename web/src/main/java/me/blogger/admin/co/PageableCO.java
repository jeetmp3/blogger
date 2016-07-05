package me.blogger.admin.co;

/**
 * @author Jitendra Singh.
 */
public class PageableCO {

	private short page;
	private short max;
	private int offset;

	public PageableCO() {
		this.page = 0;
		this.max = 10;
		this.offset = 0;
	}

	public short getPage() {
		return page;
	}

	public void setPage(short page) {
		this.page = page;
	}

	public short getMax() {
		return max;
	}

	public void setMax(short max) {
		this.max = max;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
}
