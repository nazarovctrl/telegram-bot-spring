[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.nazarovctrl/telegram-bot-spring/badge.svg)](https://mvnrepository.com/artifact/io.github.nazarovctrl/telegram-bot-spring)

## [Java documentation](https://javadoc.io/doc/io.github.nazarovctrl/telegram-bot-spring/1.0.7)
## Library [link](https://central.sonatype.com/artifact/io.github.nazarovctrl/telegram-bot-spring/1.0.7) in Maven Central
## Maven dependency

        <dependency>
            <groupId>io.github.nazarovctrl</groupId>
            <artifactId>telegram-bot-spring</artifactId>
            <version>1.0.8</version>
        </dependency>

## How to use library?
#### 

$\textcolor{red}{\textsf{*}}$ `required steps`

<details close>
  <summary>
    <h4>
      1.Add <i>bot configuration</i> to <tt><b>application.properties</b></tt>        
      $\textcolor{red}{\textsf{*}}$ 
    </h4>
  </summary>
<kbd>
   
<img width="454" alt="image_2023-08-20_21-00-24" src="https://github.com/nazarovctrl/telegram-bot-spring/assets/109890132/f8f653ce-07fa-4d8a-86d0-17389105db8c">
</kbd>

##### $\textcolor{red}{\textsf{Red line}}$ `is always required field` 
##### `bot.name` your telegram bot username
##### `bot.token` your telegram bot token
##### `bot.uri` uri to send a request to your application. If you are creating telegram bot with `webhook` you need to add `bot.uri` otherwise you don't need
##### `bot.base_url` url to send reqeust to your [Local Bot API Server](https://core.telegram.org/bots/api#using-a-local-bot-api-server) (by default `https://api.telegram.org/bot`). If you are creating telegram bot with [Local Bot API Server](https://core.telegram.org/bots/api#using-a-local-bot-api-server) you need to add `bot.base_url` otherwise you don't need

</details>

<details close>
  <summary> 
    <h4>
        2.Add annotation <tt><b>@EnableTelegramLongPollingBot</b></tt> or <tt><b>@EnableTelegramWebhookBot</b></tt>         
        $\textcolor{red}{\textsf{*}}$ 
    </h4>
  </summary>
<kbd>
<img width="616" alt="image_2023-08-20_20-52-11" src="https://github.com/nazarovctrl/telegram-bot-spring/assets/109890132/75910725-fd48-4400-9fb0-e06b1dc99e44">
</kbd>
  
##### Use `@EnableTelegramLongPollingBot` annotation for creating telegram bot ***without*** `webhook` 
##### Use `@EnableTelegramWebhookBot` annotation for telegram bot ***with*** `webhook`

</details>
<details close>
  <summary> 
    <h4>
        3.Inherit from <tt><b>@AbstractUpdateController</b></tt> abstract class 
        $\textcolor{red}{\textsf{*}}$ 
    </h4>
  </summary>
<kbd><img width="750" alt="image" src="https://github.com/nazarovctrl/telegram-bot-spring/assets/109890132/f77b4c72-b1af-4530-933a-152dc826f3a8">
</kbd>
        
##### Override `handle` method
##### Make your class as a `bean`. _In previous picture was used `@Component` annonation for making the class as a `bean`_
</details>

<details close>
  <summary>
    <h4>
      4.Send messages(text,media etc.) with <tt><b>MessageSender</b></tt>
      $\textcolor{green}{\textsf{*}}$ 
    </h4>
  </summary>
  <kbd>  

<img width="509" alt="image_2023-08-20_23-48-20" src="https://github.com/nazarovctrl/telegram-bot-spring/assets/109890132/1ddd7b70-cca3-493c-b411-a69c79955821">

  </kbd>

##### Inject `MessageSender`
##### Use `execute` method of `MessageSender`
<kbd>
  <img width="562" alt="image_2023-08-20_21-15-45" src="https://github.com/nazarovctrl/telegram-bot-spring/assets/109890132/d7c6cade-dfb5-4438-b5cb-8a24382d0ca0">
</kbd>
</details>
