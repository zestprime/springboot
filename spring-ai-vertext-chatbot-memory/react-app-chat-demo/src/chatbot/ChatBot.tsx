import React, { useState, useRef, useEffect } from "react";
import axios from "axios";
import ReactMarkdown from "react-markdown";
import './../App.css';
import {v4 as uuidv4} from "uuid";

interface Message {
  sender: "user" | "bot";
  text: string;
}

const ChatBot: React.FC = () => {
  const [isOpen, setIsOpen] = useState(false);
  const [userid] = useState(()=>`${uuidv4()}`);
  const [messages, setMessages] = useState<Message[]>([
    { sender: "bot", text: "Hi! How can I help you?" },
  ]);
  const [input, setInput] = useState("");
  const bottomRef = useRef<HTMLDivElement | null>(null);

  const toggleChat = () => setIsOpen(!isOpen);

  const handleSend = () => {
    if (!input.trim()) return;

    const userMessage: Message = { sender: "user", text: input };
    setMessages((prev) => [...prev, userMessage]);

const handleSendAA = async () => {
  let responseData = '';
  try {
    //alert("req222:"+input);
    const response = await axios.get("http://localhost:8080/user", {
      params: { 
        query:input,
        userid:userid
       },
      headers: { Accept: "application/json" },
    });
    console.log(response.data);
    responseData = response.data;
  } catch (error: any) {
    console.error(error);
    responseData = error.response?.data || "Something went wrong!";
  }

    const botMessage: Message = {
      sender: "bot",
      text: responseData
    };
    setMessages((prev) => [...prev, botMessage]);
};
handleSendAA();
setInput("");
  }
  useEffect(() => {
    bottomRef.current?.scrollIntoView({ behavior: "smooth" });
  }, [messages]);

  return (
    <div className="chatbot-container">
      {isOpen && (
        <div
          className="chatbot-box shadow"
          style={{
            width: 650,
            height: 550,
            display: "flex",
            flexDirection: "column",
            borderRadius: "12px",
            overflow: "hidden",
            backgroundColor: "#fff",
            position: "fixed",
            bottom: 80,
            right: 20,
            zIndex: 9999,
          }}
        >
          <div className="chatbot-header bg-primary text-white p-2 fw-bold">
            <span style={{ fontSize: "25px", marginTop: "2px" }}
                  >
                    🤖
                  </span>Zest Prime AI Agent
          </div>

          <div
            className="chatbot-messages p-2"
            style={{
              overflowY: "auto",
              flex: 1,
              display: "flex",
              flexDirection: "column",
              gap: "8px",
              backgroundColor: "#f5f5f5",
            }}
          >
            {messages.map((msg, index) => (
              <div
                key={index}
                style={{
                  alignSelf: msg.sender === "user" ? "flex-end" : "flex-start",
                  backgroundColor:
                    msg.sender === "user" ? "#70a2d8ff" : "#d0c1c1ff",
                  padding: "10px",
                  borderRadius: "12px",
                  maxWidth: "95%",
                  display: "flex",
                  alignItems:
                    msg.sender === "bot" ? "flex-start" : "center",
                  gap: "6px",
                  wordBreak: "break-word",
                }}
              >
                {msg.sender === "bot" && (
                  <span
                    role="img"
                    aria-label="bot"
                    style={{ fontSize: "25px", marginTop: "2px" }}
                  >
                    🤖
                  </span>
                )}

                <span
                  style={{
                    whiteSpace: "pre-wrap",
                    wordBreak: "break-word",
                    fontFamily: "Segoe UI, sans-serif",
                    fontSize: "15px",
                    lineHeight: "1.5",
                    textAlign:"left",
                    
                  }}
                >
                  <ReactMarkdown>{msg.text}</ReactMarkdown>
                </span>

                
              </div>
            ))}
            <div ref={bottomRef} />
          </div>

       <div className="chatbot-input p-2">
  <div style={{ display: "flex", gap: "8px" }}>
    
    <textarea
      className="form-control"
      style={{
        minHeight: "44px",
        fontSize: "2rem",
        flex: 1,
        border: "1px solid #ccc",
        borderRadius: "4px",
        padding: "8px",
        resize: "none",            // prevents manual resize if you don’t want it
        whiteSpace: "pre-wrap",
        wordBreak: "break-word"
      }}
      value={input}
      onChange={(e) => setInput(e.target.value)}
       onKeyDown={(e) => {
        if (e.key === "Enter" && !e.shiftKey) {
          e.preventDefault();  // stop new line
          handleSend();
        }
      }
    }
      placeholder="Type your message"
/>
    <button
      className="btn btn-primary"
      style={{ height: "44px", fontSize: "1rem", padding: "0 16px", backgroundColor: "blue",  fontWeight: "bold",color:"white"}}
      onClick={handleSend}
    >
      Send
    </button>
  </div>
</div>

        </div>
      )}

      <button
        className="chatbot-toggle-btn rounded-circle"
        onClick={toggleChat}
        style={{
          position: "fixed",
          bottom: 20,
          right: 20,
          width: 50,
          height: 50,
          fontSize: "20px",
          zIndex: 9999,
        }}
      >
        💬
      </button>
    </div>
  );
};

export default ChatBot;
