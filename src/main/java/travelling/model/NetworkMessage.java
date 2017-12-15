package travelling.model;

import java.io.Serializable;

public class NetworkMessage implements Serializable{
	
	private String message;
	private Object attachment;
	private AttachmentType attachmentType;
	
	
	public NetworkMessage() {
		super();
		this.message = null;
		this.attachment = null;
		this.attachmentType = null;
	}
	
	public NetworkMessage(String request, Object attachment, AttachmentType attachmentType) {
		super();
		this.message = request;
		this.attachment = attachment;
		this.attachmentType = attachmentType;
	}
	public String getRequest() {
		return message;
	}
	public void setRequest(String request) {
		this.message = request;
	}
	public Object getAttachment() {
		return attachment;
	}
	public void setAttachment(Object attachment) {
		this.attachment = attachment;
	}
	public AttachmentType getAttachmentType() {
		return attachmentType;
	}
	public void setAttachmentType(AttachmentType attachmentType) {
		this.attachmentType = attachmentType;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ message="+message+", type="+attachmentType+", attachment="+attachment.toString()+" ]";
	}
}
