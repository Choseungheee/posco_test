package com.posco.web;

import com.posco.web.auth.LoginDTO;
import com.posco.web.auth.TokenDTO;
import com.posco.web.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class WebController {

    @Autowired
    private UserService userService;
    @Autowired
    private CalendarService calendarService;
    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String login(Model model){
        return "login";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model){
        System.out.println("index 들어옴");
//        ResponseObserver<StreamingRecognizeResponse> responseObserver = null;
//        try (SpeechClient client = SpeechClient.create()) {
//
//            responseObserver = new ResponseObserver<StreamingRecognizeResponse>() {
//                ArrayList<StreamingRecognizeResponse> responses = new ArrayList<>();
//
//                public void onStart(StreamController controller) {
//                }
//
//                public void onResponse(StreamingRecognizeResponse response) {
//                    responses.add(response);
//                }
//
//                public void onComplete() {
//                    String record = "";
//
//                    for (StreamingRecognizeResponse response : responses) {
//                        StreamingRecognitionResult result = response.getResultsList().get(0);
//                        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
//                        record += alternative.getTranscript();
//                        System.out.printf("Transcript : %s\n", alternative.getTranscript());
//                    }
//                }
//
//                public void onError(Throwable t) {
//                    System.out.println(t);
//                }
//            };
//
//            ClientStream<StreamingRecognizeRequest> clientStream = client.streamingRecognizeCallable()
//                    .splitCall(responseObserver);
//
//            RecognitionConfig recognitionConfig = RecognitionConfig.newBuilder()
//                    .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16).setLanguageCode("ko-KR")// 한국어 설정
//                    .setSampleRateHertz(16000).build();
//            StreamingRecognitionConfig streamingRecognitionConfig = StreamingRecognitionConfig.newBuilder()
//                    .setConfig(recognitionConfig).build();
//
//            StreamingRecognizeRequest request = StreamingRecognizeRequest.newBuilder()
//                    .setStreamingConfig(streamingRecognitionConfig).build(); // The first request in a streaming call
//            // has to be a config
//
//            clientStream.send(request);
//            // SampleRate:16000Hz, SampleSizeInBits: 16, Number of channels: 1, Signed:
//            // true,
//            // bigEndian: false
//            AudioFormat audioFormat = new AudioFormat(16000, 16, 1, true, false);
//            DataLine.Info targetInfo = new Info(TargetDataLine.class, audioFormat); // Set the system information to
//            // read from the microphone audio
//            // stream
//
//            if (!AudioSystem.isLineSupported(targetInfo)) {
//                System.out.println("Microphone not supported");
//                System.exit(0);
//            }
//            // Target data line captures the audio stream the microphone produces.
//            TargetDataLine targetDataLine = (TargetDataLine) AudioSystem.getLine(targetInfo);
//            targetDataLine.open(audioFormat);
//            targetDataLine.start();
//            System.out.println("Start speaking");
//            long startTime = System.currentTimeMillis();
//            // Audio Input Stream
//            AudioInputStream audio = new AudioInputStream(targetDataLine);
//            while (true) {
//                long estimatedTime = System.currentTimeMillis() - startTime;
//                byte[] data = new byte[6400];
//                audio.read(data);
//                if (estimatedTime > 6000) { // 60 seconds 스트리밍 하는 시간설정(기본 60초)
//                    System.out.println("Stop speaking.");
//                    targetDataLine.stop();
//                    targetDataLine.close();
//                    break;
//                }
//                request = StreamingRecognizeRequest.newBuilder().setAudioContent(ByteString.copyFrom(data)).build();
//                clientStream.send(request);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        responseObserver.onComplete(); //완료 이벤트 발생
        //        String apiKey = "YOUR_API_KEY_HERE";
//        String prompt = "Hello, how can I assist you?";
//
//        OpenAIGPT openai = new OpenAIGPT(apiKey);
//        Engine engine = new Engine(openai);
//
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.print("User: ");
//            String userMessage = scanner.nextLine();
//
//            CompletionRequest completionRequest = new CompletionRequest.Builder()
//                    .prompt(prompt + "\nUser: " + userMessage)
//                    .maxTokens(50)
//                    .build();
//
//            ChatCompletion completion = engine.completeChat(completionRequest);
//            String response = completion.getChoices().get(0).getText();
//
//            System.out.println("ChatGPT: " + response);
//
//            // 대화 종료 조건 설정
//            if (userMessage.equalsIgnoreCase("bye")) {
//                break;
//            }
//        }

        model.addAttribute("data", "babo");
        return "test";
    }
    @RequestMapping(value = "/myPage", method = RequestMethod.GET)
    public String myPage(Model model){
        return "myPage";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestParam String email, @RequestParam String password, Model model){
//        if(!userService.isExistById(loginDTO.getId())){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Message("존재하지 않는 사용자 입니다"));
//        }\
        LoginDTO loginDTO = LoginDTO.builder().email(email).password(password).build();
        TokenDTO tokenDTO = userService.loginUser(loginDTO);
        model.addAttribute("loginUser", loginDTO);
        return "test";
    }
    @GetMapping("/event") //ajax 데이터 전송 URL
    public @ResponseBody List<Map<String, Object>> getEvent(){
        return calendarService.getEventList();
    }
}
