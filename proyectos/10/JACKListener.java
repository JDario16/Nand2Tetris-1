// Generated from JACK.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JACKParser}.
 */
public interface JACKListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JACKParser#classes}.
	 * @param ctx the parse tree
	 */
	void enterClasses(JACKParser.ClassesContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#classes}.
	 * @param ctx the parse tree
	 */
	void exitClasses(JACKParser.ClassesContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#classVarDec}.
	 * @param ctx the parse tree
	 */
	void enterClassVarDec(JACKParser.ClassVarDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#classVarDec}.
	 * @param ctx the parse tree
	 */
	void exitClassVarDec(JACKParser.ClassVarDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(JACKParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(JACKParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#subroutineDec}.
	 * @param ctx the parse tree
	 */
	void enterSubroutineDec(JACKParser.SubroutineDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#subroutineDec}.
	 * @param ctx the parse tree
	 */
	void exitSubroutineDec(JACKParser.SubroutineDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(JACKParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(JACKParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#subroutineBody}.
	 * @param ctx the parse tree
	 */
	void enterSubroutineBody(JACKParser.SubroutineBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#subroutineBody}.
	 * @param ctx the parse tree
	 */
	void exitSubroutineBody(JACKParser.SubroutineBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#varDec}.
	 * @param ctx the parse tree
	 */
	void enterVarDec(JACKParser.VarDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#varDec}.
	 * @param ctx the parse tree
	 */
	void exitVarDec(JACKParser.VarDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(JACKParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(JACKParser.ClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#subroutineName}.
	 * @param ctx the parse tree
	 */
	void enterSubroutineName(JACKParser.SubroutineNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#subroutineName}.
	 * @param ctx the parse tree
	 */
	void exitSubroutineName(JACKParser.SubroutineNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#varName}.
	 * @param ctx the parse tree
	 */
	void enterVarName(JACKParser.VarNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#varName}.
	 * @param ctx the parse tree
	 */
	void exitVarName(JACKParser.VarNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(JACKParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(JACKParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(JACKParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(JACKParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#letStatement}.
	 * @param ctx the parse tree
	 */
	void enterLetStatement(JACKParser.LetStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#letStatement}.
	 * @param ctx the parse tree
	 */
	void exitLetStatement(JACKParser.LetStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(JACKParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(JACKParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(JACKParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(JACKParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#doStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoStatement(JACKParser.DoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#doStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoStatement(JACKParser.DoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(JACKParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(JACKParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(JACKParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(JACKParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(JACKParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(JACKParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#subroutineCall}.
	 * @param ctx the parse tree
	 */
	void enterSubroutineCall(JACKParser.SubroutineCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#subroutineCall}.
	 * @param ctx the parse tree
	 */
	void exitSubroutineCall(JACKParser.SubroutineCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(JACKParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(JACKParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(JACKParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(JACKParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#unaryOP}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOP(JACKParser.UnaryOPContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#unaryOP}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOP(JACKParser.UnaryOPContext ctx);
	/**
	 * Enter a parse tree produced by {@link JACKParser#keywordConstant}.
	 * @param ctx the parse tree
	 */
	void enterKeywordConstant(JACKParser.KeywordConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link JACKParser#keywordConstant}.
	 * @param ctx the parse tree
	 */
	void exitKeywordConstant(JACKParser.KeywordConstantContext ctx);
}