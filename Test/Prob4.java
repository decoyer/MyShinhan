// 파일 작업을 위한 객체 직렬화
class Product implements Serializable {
	private String model_name;
	private int price;
	private String company;

	public Product(String model_name, int price, String company) {
		super();
		this.model_name = model_name;
		this.price = price;
		this.company = company;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Product [model_name=" + model_name + ", price=" + price
				+ ", company=" + company + "]";
	}
}

public class Prob4 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Product[] prodList = {
				new Product("NT450R5E-K24S", 500000, "삼성전자"),
				new Product("15UD340-LX2CK", 400000, "LG전자"),
				new Product("G2-K3T32AV", 600000, "HP") };
		HashSet<Product> product_hs = makeHashSet(prodList, 500000);
		makeFile(product_hs);
		readFile();
	}

	// price 값 이상의 상품만 저장
	private static HashSet<Product> makeHashSet(Product[] prodList, int price) {
		HashSet<Product> set = new HashSet<>();

		for (Product p : prodList)
			if (p.getPrice() >= price)
				set.add(p);

		return set;
	}

	// 파일 쓰기
	private static void makeFile(HashSet resultList) throws IOException {
		try (FileOutputStream fos = new FileOutputStream("data.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			System.out.println("*특정 금액 이상의 상품결과입니다.********************");
			resultList.stream().forEach(i -> System.out.println(i));

			oos.writeObject(resultList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 파일 읽기
	private static void readFile() throws IOException, ClassNotFoundException {
		try (FileInputStream fis = new FileInputStream("data.txt");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			HashSet<Product> set = (HashSet<Product>) ois.readObject();

			System.out.println("*readFile결과입니다.********************");
			set.stream().forEach(i -> System.out.println(i));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
