public class Tree {

	private NodeTree root, aux;

	public Tree() {
	}

	public boolean add(int numero) {
		boolean retorno = false;
		if (root == null) {
			root = new NodeTree(numero);
			retorno = true;
		} else {
			aux = root;
			if (aux.getRight() == null && numero > aux.getInfo()) {
				aux.getRight().setInfo(numero);
				retorno = true;
			} else if (aux.getLeft() == null && numero < aux.getInfo()) {
				aux.getLeft().setInfo(numero);
				retorno = true;
			} else {
				while (aux.getLeft() != null || aux.getRight() != null) {
					if (numero > aux.getInfo()) {
						if (aux.getRight().getInfo() < numero) {
							aux = aux.getLeft();
						} else {
							aux = aux.getRight();
						}
					} else {
						if (aux.getLeft().getInfo() < numero) {
							aux = aux.getLeft();
						} else {
							aux = aux.getRight();
						}
					}
				}
				if (numero < aux.getInfo()) {
					aux.getLeft().setInfo(numero);
					retorno = true;
				} else {
					aux.getRight().setInfo(numero);
					retorno = true;
				}
			}
		}
		return retorno;
	}

	public boolean delete(int numero){
		boolean retorno = false;
		NodeTree auxPai;
		aux = root;
		if(numero == aux.getInfo() || aux.getLeft() == null && aux.getRight() == null){
			aux = null;
			retorno = true;
		} else if(numero == aux.getInfo() || aux.getLeft() != null || aux.getRight() != null){
			if(numero == aux.getLeft().getInfo()){
				aux.setLeft(null);
				retorno = true;
			}else{
				aux.setRight(null);
				retorno = true;
			}
		} else{
			auxPai = null;
			while(aux != null){
				if(numero < aux.getInfo()){
					auxPai = aux;
					aux = aux.getLeft();
				}else if(numero > aux.getInfo()){
					auxPai = aux;
					aux = aux.getRight();
				} else{
					if(aux.getLeft() != null ){
						aux.setInfo(aux.getRight().getInfo());
						retorno = true;
					}else if(aux.getRight() != null){
						aux.setInfo(aux.getLeft().getInfo());
						retorno = true;
					}
				}
			}
		return retorno;
	}

	public void searchElement(int numero) {
		aux = root;

	}
}
