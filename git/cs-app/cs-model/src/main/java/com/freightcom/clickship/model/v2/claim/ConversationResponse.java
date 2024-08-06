package com.freightcom.clickship.model.v2.claim;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversationResponse {
    
	private List<Thread> threads;

    @Data
    @EqualsAndHashCode(callSuper = false)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Thread {
        private String id;
        private String customer_id;
        private ContextId context_id;
        private String subject;
        private String created_at;
        private CreatedBy created_by;
        private List<Message> messages;
        private List<File> files;

        @Data
        @EqualsAndHashCode(callSuper = false)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ContextId {
            private String id;
            private String type;
			public String getId() {
				return id;
			}
			public ContextId setId(String id) {
				this.id = id;
				return this;
			}
			public String getType() {
				return type;
			}
			public ContextId setType(String type) {
				this.type = type;
				return this;
			}
            
        }

        @Data
        @EqualsAndHashCode(callSuper = false)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class CreatedBy {
            private String id;
            private String type;
            private String user_first_name;
            private String user_last_name;
			public String getId() {
				return id;
			}
			public CreatedBy setId(String id) {
				this.id = id;
				return this;
			}
			public String getType() {
				return type;
			}
			public CreatedBy setType(String type) {
				this.type = type;
				return this;
			}
			public String getUser_first_name() {
				return user_first_name;
			}
			public CreatedBy setUser_first_name(String user_first_name) {
				this.user_first_name = user_first_name;
				return this;
			}
			public String getUser_last_name() {
				return user_last_name;
			}
			public CreatedBy setUser_last_name(String user_last_name) {
				this.user_last_name = user_last_name;
				return this;
			}
        }

        @Data
        @EqualsAndHashCode(callSuper = false)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Message {
            private String id;
            private String customer_id;
            private String thread_id;
            private ContextId context_id;
            private String subject;
            private String author_type;
            private String content;
            @JsonProperty("is_update_request")
            private boolean is_update_request;
            private String created_at;
            private CreatedBy created_by;
            @JsonProperty("is_read")
            private boolean is_read;
            private Object context;
			public String getId() {
				return id;
			}
			public Message setId(String id) {
				this.id = id;
				return this;
			}
			public String getCustomer_id() {
				return customer_id;
			}
			public Message setCustomer_id(String customer_id) {
				this.customer_id = customer_id;
				return this;
			}
			public String getThread_id() {
				return thread_id;
			}
			public Message setThread_id(String thread_id) {
				this.thread_id = thread_id;
				return this;
			}
			public ContextId getContext_id() {
				return context_id;
			}
			public Message setContext_id(ContextId context_id) {
				this.context_id = context_id;
				return this;
			}
			public String getSubject() {
				return subject;
			}
			public Message setSubject(String subject) {
				this.subject = subject;
				return this;
			}
			public String getAuthor_type() {
				return author_type;
			}
			public Message setAuthor_type(String author_type) {
				this.author_type = author_type;
				return this;
			}
			public String getContent() {
				return content;
			}
			public Message setContent(String content) {
				this.content = content;
				return this;
			}
			public boolean isIs_update_request() {
				return is_update_request;
			}
			public Message setIs_update_request(boolean is_update_request) {
				this.is_update_request = is_update_request;
				return this;
			}
			public String getCreated_at() {
				return created_at;
			}
			public Message setCreated_at(String created_at) {
				this.created_at = created_at;
				return this;
			}
			public CreatedBy getCreated_by() {
				return created_by;
			}
			public Message setCreated_by(CreatedBy created_by) {
				this.created_by = created_by;
				return this;
			}
			public boolean isIs_read() {
				return is_read;
			}
			public Message setIs_read(boolean is_read) {
				this.is_read = is_read;
				return this;
			}
			public Object getContext() {
				return context;
			}
			public Message setContext(Object context) {
				this.context = context;
				return this;
			}
            
        }

		public String getId() {
			return id;
		}

		public Thread setId(String id) {
			this.id = id;
			return this;
		}

		public String getCustomer_id() {
			return customer_id;
		}

		public Thread setCustomer_id(String customer_id) {
			this.customer_id = customer_id;
			return this;
		}

		public ContextId getContext_id() {
			return context_id;
		}

		public Thread setContext_id(ContextId context_id) {
			this.context_id = context_id;
			return this;
		}

		public String getSubject() {
			return subject;
		}

		public Thread setSubject(String subject) {
			this.subject = subject;
			return this;
		}

		public String getCreated_at() {
			return created_at;
		}

		public Thread setCreated_at(String created_at) {
			this.created_at = created_at;
			return this;
		}

		public CreatedBy getCreated_by() {
			return created_by;
		}

		public Thread setCreated_by(CreatedBy created_by) {
			this.created_by = created_by;
			return this;
		}

		public List<Message> getMessages() {
			return messages;
		}

		public Thread setMessages(List<Message> messages) {
			this.messages = messages;
			return this;
		}

		public List<File> getFiles() {
			return files;
		}

		public Thread setFiles(List<File> files) {
			this.files = files;
			return this;
		}
    }

	public List<Thread> getThreads() {
		return threads;
	}

	public ConversationResponse setThreads(List<Thread> threads) {
		this.threads = threads;
		return this;
	}
    
}