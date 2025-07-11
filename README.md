# 名前と年齢を登録できるAPIを実装

- 入力: name, age
- 出力: 登録されたユーザー情報
- idは自動採番

## ゴールに必要な部品を逆算

| 目的           | 必要な部品（レイヤー）                 | 担当アノテーション例                        |
| ------------ | --------------------------- | --------------------------------- |
| データをDBに保存したい | **Entity** + **Repository** | `@Entity`, `@Id`                  |
| 登録ロジックを書きたい  | **Service**                 | `@Service`                        |
| APIを受け取りたい   | **Controller**              | `@RestController`, `@PostMapping` |
| 入出力データを扱いたい  | **DTO（必要であれば）**             |                                   |

## 順番に作る
1. Entity を作る（DBに保存する構造）
2. Repository を作る（保存・取得処理）
3. Service を作る（ビジネス処理、今回は保存だけ）
4. Controller を作る（APIの入り口）

## 出てくるアノテーション
|アノテーション|説明                                                     
|------------------------|--------------------------------------------------------------
| @Entity                | DBのテーブルとマッピングされるクラスであることを示す（JPA） 
| @Data                  | getter/setter, toString, equals, hashCode を自動生成（Lombok） 
| @NoArgsConstructor     | 引数なしコンストラクタを自動生成（Lombok） 
| @AllArgsConstructor    | 全てのフィールドを引数に持つコンストラクタを自動生成（Lombok） 
| @Builder               | Builderパターンのメソッドを生成（User.builder()...）（Lombok） 

### アノテーションが便利？
- **自分で全部書かなくて済む**
例：getter/setterやコンストラクタを手動で書く代わりに、@Dataや@NoArgsConstructorを付けるだけで自動生成される
- **フレームワークが処理を自動化してくれる**
例：@RestControllerを付けたクラスを自動的にAPIのルーティング対象にする
- **コードの意図を明確に伝えられる**
例：@Entityがあると「このクラスはDBのテーブルとして使う」ということがすぐわかる
