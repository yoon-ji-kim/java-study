package httpd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private Socket socket;
	private static final String DOCUMENT_ROOT = "./webapp";
	public RequestHandler( Socket socket ) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream outputStream = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = ( InetSocketAddress )socket.getRemoteSocketAddress();
			consoleLog( "connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort() );
				
			String request = null;
			// 요청에 따라 해당하는 것에 응답
			while(true) {
				String line =br.readLine();
				//브라우저 연결 끊김
				if(line == null) {
					break;
				}
				// SimpleHttpServer(프로그램이름)는 요청의 헤더만 처리함
				if("".equals(line)) {
					//헤더가 끝나면 while에서 나감
					break;
				}
				//요청 헤더의 첫번째 라인만 읽음
				if(request == null) {
					request = line;
					break;
				}
			}
/*
			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.            encoding
//			outputStream.write( "HTTP/1.1 200 OK\r\n".getBytes( "UTF-8" ) );
//			outputStream.write( "Content-Type:text/html; charset=utf-8\r\n".getBytes( "UTF-8" ) );
//			outputStream.write( "\r\n".getBytes() );
//			outputStream.write( "<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes( "UTF-8" ) );
*/		
			
			//요청처리          GET / HTTP/1.1
			//request 파싱하기 //메소드, URL,HTTP 버전은 뭔지 =>" "로 구분, 3개, 대문자로 보내는 것으로 약속
			String[] tokens = request.split(" ");
			consoleLog(request);
			if("GET".equals(tokens[0])) {
				//GET이면 
//				consoleLog(request);
				//정적자원을 응답           응답,         url,     프로토콜
				//                     HTTP/1.1 200 OK
				responseStaticResource(outputStream,tokens[1], tokens[2]);
				
			}else {
				//method가 POST, PUT, DELETE, HEAD, CONNECT 일때,
				//SimpleHttpServer에서는 무시하기(400 Bad Request로 응답하기) --> 응답안하면 안됨, response해줘야함!
//				HTTP/1.1 400 Bad  (user/login)
				response400Error(outputStream, tokens[2]);
				
			}

		} catch( Exception ex ) {
			consoleLog( "error:" + ex );
		} finally {
			// clean-up
			try{
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}
				
			} catch( IOException ex ) {
				consoleLog( "error:" + ex );
			}
		}			
	}

	private void responseStaticResource 
	(OutputStream outputStream, String url, String protocol) throws IOException{
		//default(welcome) 파일 세팅
		if("/".equals(url)) {
			//url이 /면 바꾸기
			url = "/index.html";
		}
		
		//읽기                  
		File file = new File(DOCUMENT_ROOT +url);
		//NIO(New IO) .readAllBytes(path)  byte로 통째로 한번에 다읽음
		if(!file.exists()) {
			response404Error(outputStream, protocol);
			return;
		}
		//응답의 바디에 채울 내용
		byte[] body=Files.readAllBytes(file.toPath());
		//~? css 적용하려고 추가했는데 Files.probeContentType 찾아보기
		String contentType =  Files.probeContentType(file.toPath());
		
		//응답
//		outputStream.write( "HTTP/1.1 200 OK\r\n".getBytes( "UTF-8" ) );
		outputStream.write( (protocol+" 200 OK\r\n").getBytes( "UTF-8" ) );
		outputStream.write(("Content-Type:"+contentType+"; charset=utf-8\r\n").getBytes( "UTF-8" ) );
		outputStream.write( "\r\n".getBytes() );
		//바디
		outputStream.write( body);
		
	}
	private void response400Error(OutputStream outputStream, String protocol) throws IOException {
		//HTTP/1.1 400 Bad Request
		//Content-Type:....; charset = ~~~ )
		// \r\n
		// ....내용
		File file = new File(DOCUMENT_ROOT + "/error/400.html");
		if(!file.exists()) {
			response404Error(outputStream, protocol);
			return;
		}
		byte[] body=Files.readAllBytes(file.toPath());
		String contentType =  Files.probeContentType(file.toPath());
		outputStream.write( (protocol+" 400 Bad Request\r\n").getBytes( "UTF-8" ) );
		outputStream.write(("Content-Type:"+contentType+"; charset=utf-8\r\n").getBytes( "UTF-8" ) );
		outputStream.write( "\r\n".getBytes() );
		outputStream.write(body);
	}
	private void response404Error(OutputStream outputStream, String protocol) throws IOException {
		//HTTP/1.1 404 Not Found
		//Content-Type:....; charset = ~~~ )
		// \r\n
		// ....내용
		File file = new File(DOCUMENT_ROOT + "/error/404.html");
		byte[] body=Files.readAllBytes(file.toPath());
		String contentType =  Files.probeContentType(file.toPath());
		outputStream.write( (protocol+" 404 Not Found\r\n").getBytes( "UTF-8" ) );
		outputStream.write(("Content-Type:"+contentType+"; charset=utf-8\r\n").getBytes( "UTF-8" ) );
		outputStream.write( "\r\n".getBytes() );
		outputStream.write(body);
	}

	public void consoleLog( String message ) {
		System.out.println( "[Httpd#" + getId() + "] " + message );
	}
}
