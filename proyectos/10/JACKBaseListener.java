// Generated from JACK.g4 by ANTLR 4.7

import java.io.PrintWriter;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class provides an empty implementation of {@link JACKListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class JACKBaseListener implements JACKListener {
	
	//MainJack MainJack = new MainJack();

	@Override public void enterClasses(JACKParser.ClassesContext ctx) { 
		MainJack.pw.println("<class>");
		MainJack.pwT.println("<tokens>");

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitClasses(JACKParser.ClassesContext ctx) {
		MainJack.pw.println("</class>");
		MainJack.pwT.println("</tokens>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterClassVarDec(JACKParser.ClassVarDecContext ctx) {
		MainJack.pw.println("<classVarDec>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitClassVarDec(JACKParser.ClassVarDecContext ctx) {
		MainJack.pw.println("</classVarDec>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterType(JACKParser.TypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitType(JACKParser.TypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSubroutineDec(JACKParser.SubroutineDecContext ctx) {
		MainJack.pw.println("<subroutineDec>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSubroutineDec(JACKParser.SubroutineDecContext ctx) { 
		MainJack.pw.println("</subroutineDec>");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterParameterList(JACKParser.ParameterListContext ctx) {
		MainJack.pw.println("<parameterList>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitParameterList(JACKParser.ParameterListContext ctx) { 
		MainJack.pw.println("</parameterList>");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSubroutineBody(JACKParser.SubroutineBodyContext ctx) {
		MainJack.pw.println("<subroutineBody>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSubroutineBody(JACKParser.SubroutineBodyContext ctx) {
		MainJack.pw.println("</subroutineBody>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterVarDec(JACKParser.VarDecContext ctx) {
		MainJack.pw.println("<varDec>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVarDec(JACKParser.VarDecContext ctx) {
		MainJack.pw.println("</varDec>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterClassName(JACKParser.ClassNameContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitClassName(JACKParser.ClassNameContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSubroutineName(JACKParser.SubroutineNameContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSubroutineName(JACKParser.SubroutineNameContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterVarName(JACKParser.VarNameContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVarName(JACKParser.VarNameContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStatements(JACKParser.StatementsContext ctx) {
		MainJack.pw.println("<statements>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStatements(JACKParser.StatementsContext ctx) {
		MainJack.pw.println("</statements>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStatement(JACKParser.StatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStatement(JACKParser.StatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLetStatement(JACKParser.LetStatementContext ctx) {
		MainJack.pw.println("<letStatement>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLetStatement(JACKParser.LetStatementContext ctx) {
		MainJack.pw.println("</letStatement>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIfStatement(JACKParser.IfStatementContext ctx) {
		MainJack.pw.println("<ifStatement>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIfStatement(JACKParser.IfStatementContext ctx) {
		MainJack.pw.println("</ifStatement>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterWhileStatement(JACKParser.WhileStatementContext ctx) {
		MainJack.pw.println("<whileStatement>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitWhileStatement(JACKParser.WhileStatementContext ctx) {
		MainJack.pw.println("</whileStatement>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDoStatement(JACKParser.DoStatementContext ctx) {
		MainJack.pw.println("<doStatement>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDoStatement(JACKParser.DoStatementContext ctx) {
		MainJack.pw.println("</doStatement>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterReturnStatement(JACKParser.ReturnStatementContext ctx) {
		MainJack.pw.println("<returnStatement>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitReturnStatement(JACKParser.ReturnStatementContext ctx) {
		MainJack.pw.println("</returnStatement>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpression(JACKParser.ExpressionContext ctx) {
		MainJack.pw.println("<expression>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpression(JACKParser.ExpressionContext ctx) {
		MainJack.pw.println("</expression>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTerm(JACKParser.TermContext ctx) {
		MainJack.pw.println("<term>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTerm(JACKParser.TermContext ctx) {
		MainJack.pw.println("</term>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSubroutineCall(JACKParser.SubroutineCallContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSubroutineCall(JACKParser.SubroutineCallContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpressionList(JACKParser.ExpressionListContext ctx) {
		MainJack.pw.println("<expressionList>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpressionList(JACKParser.ExpressionListContext ctx) {
		MainJack.pw.println("</expressionList>");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterOp(JACKParser.OpContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitOp(JACKParser.OpContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterUnaryOP(JACKParser.UnaryOPContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitUnaryOP(JACKParser.UnaryOPContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterKeywordConstant(JACKParser.KeywordConstantContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitKeywordConstant(JACKParser.KeywordConstantContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 *
	 * 
	 * metodo que retorna el token ubicado en las ramas del arbol 
	 * Se guarda el token y la etiqueta del tipo correspondiente en un string y luego 
	 * se hace la transformacion del token
	 */
	@Override public void visitTerminal(TerminalNode node) {
		int token = node.getSymbol().getType();
		String type = type(token);
		String text = node.getText();
		if(text.equals("<")){
			text = "&lt;";
		}else if(text.equals(">")){
			text = "&gt;";
		}else if(text.equals("\"")){
			text = "&quot;";
		}else if(text.equals("&")){
			text = "&amp;";
		}else if(token == 44){
			text = text.substring(1,text.length()-1);
		}else{
			text = text;
		}
		MainJack.pw.println("<" + type + "> " + text + " </" + type + ">" );
		MainJack.pwT.println("<" + type + "> " + text + " </" + type + ">");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 * 
	 */
	 
	@Override public void visitErrorNode(ErrorNode node) { }
	 /**
	 * metodo que retorna un string que contiene el tipo del token
	 * @param token 
	 * @return String con el tipo del token
	 */
	public String type(int type){
		if(type==1 || type==11 || type==12 || type==13|| type==5|| type==4|| type==17|| type==8|| type==9|| type==10|| type==14|| type==37|| type==38
		|| type==39|| type==40|| type==18|| type==25|| type==22|| type==23|| type==24|| type==26){
			return "keyword";
		}else if(type==43){
			return "integerConstant";
		}else if(type==44){
			return "stringConstant";
		}else if(type==46){
			return "identifier";
		}else{
			return "symbol";
		}
	}
}